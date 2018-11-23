package nl.pvanassen.christmas.tree.animation.disco.controller

import io.micronaut.websocket.WebSocketSession
import io.micronaut.websocket.annotation.OnMessage
import io.micronaut.websocket.annotation.ServerWebSocket
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import nl.pvanassen.christmas.tree.animation.disco.animation.Disco
import nl.pvanassen.christmas.tree.animation.disco.model.AnimationModel


@ServerWebSocket("/animation")
class DiscoController(private val disco: Disco) {

    private val fps = 60

    private val subscriber = Schedulers.single()

    @OnMessage
    fun onMessage(
            message: AnimationModel,
            session: WebSocketSession) {

        Observable.fromIterable((0..message.seconds * fps))
                .map { disco.tick() }
                .flatMap { Single.fromPublisher(session.send(it)).toObservable()}
                .subscribeOn(subscriber)
                .subscribe()
    }
}