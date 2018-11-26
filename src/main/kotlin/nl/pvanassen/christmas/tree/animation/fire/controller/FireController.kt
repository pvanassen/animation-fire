package nl.pvanassen.christmas.tree.animation.fire.controller

import io.micronaut.websocket.annotation.ServerWebSocket
import nl.pvanassen.christmas.tree.animation.common.controller.AnimationController
import nl.pvanassen.christmas.tree.animation.fire.animation.Fire

@ServerWebSocket("/animation")
class FireController(private val fire: Fire): AnimationController() {

    override fun tick() = fire.tick()
}