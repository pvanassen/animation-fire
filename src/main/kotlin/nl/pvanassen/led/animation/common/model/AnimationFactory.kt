package nl.pvanassen.led.animation.common.model

import io.ktor.server.application.*
import io.ktor.server.config.*
import nl.pvanassen.christmas.tree.canvas.Canvas

interface AnimationFactory<T> {
    fun getAnimation(canvas: Canvas,
                     ledPanelModel: LedPanelModel,
                     config: ApplicationConfig
    ): Animation<T>
}