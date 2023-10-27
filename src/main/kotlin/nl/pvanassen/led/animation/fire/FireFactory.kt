package nl.pvanassen.led.animation.fire

import io.ktor.server.config.*
import nl.pvanassen.led.animation.common.canvas.Canvas
import nl.pvanassen.led.animation.common.model.AnimationFactory
import nl.pvanassen.led.animation.common.model.Registration

class FireFactory : AnimationFactory<Any> {
    override fun getAnimation(
        canvas: Canvas,
        pixels: List<Int>,
        config: ApplicationConfig
    ) = Fire(canvas)

    override fun getRegistrationInfo(config: ApplicationConfig) = Registration("fire")
}