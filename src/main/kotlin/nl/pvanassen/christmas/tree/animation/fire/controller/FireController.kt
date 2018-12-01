package nl.pvanassen.christmas.tree.animation.fire.controller

import io.micronaut.http.annotation.Controller
import nl.pvanassen.christmas.tree.animation.common.controller.AnimationController
import nl.pvanassen.christmas.tree.animation.fire.animation.Fire

@Controller
class FireController(private val fire: Fire): AnimationController() {

    override fun getFrame() = fire.tick()
}