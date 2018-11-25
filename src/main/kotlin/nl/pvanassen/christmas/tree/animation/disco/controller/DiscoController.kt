package nl.pvanassen.christmas.tree.animation.disco.controller

import io.micronaut.websocket.annotation.ServerWebSocket
import nl.pvanassen.christmas.tree.animation.disco.animation.Disco
import nl.pvanassen.christmas.tree.animation.common.controller.AnimationController

@ServerWebSocket("/animation")
class DiscoController(private val disco: Disco): AnimationController() {

    override fun tick() = disco.tick()
}