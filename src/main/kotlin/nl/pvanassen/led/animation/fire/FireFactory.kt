package nl.pvanassen.led.animation.fire

import io.ktor.server.config.*
import nl.pvanassen.led.animation.common.canvas.Canvas
import nl.pvanassen.led.animation.common.model.AnimationFactory
import nl.pvanassen.led.animation.common.model.LedPanelModel

class FireFactory : AnimationFactory<Any> {
    override fun getAnimation(
        canvas: Canvas,
        ledPanelModel: LedPanelModel,
        config: ApplicationConfig
    ) = Fire(canvas)
}