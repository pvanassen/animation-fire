package nl.pvanassen.christmas.tree.animation.fire.animation

import nl.pvanassen.christmas.tree.animation.common.util.CommonUtils
import nl.pvanassen.christmas.tree.canvas.Canvas
import java.awt.image.BufferedImage
import java.io.IOException
import java.io.UncheckedIOException
import javax.imageio.ImageIO
import javax.inject.Singleton

@Singleton
class Fire(private val canvas:Canvas) {
    private val fireImage: BufferedImage
    private var x: Int = 0
    private var y: Int = 0

    init {
        try {
            fireImage = ImageIO.read(javaClass.getResourceAsStream("/fire1.png"))
        } catch (e: IOException) {
            throw UncheckedIOException(e)
        }
        x = -(fireImage.width / 2)
    }

    fun tick():ByteArray {
        val moveX = CommonUtils.getRandom(SKEW * 2 + 1) - SKEW
        val moveY = CommonUtils.getRandom(SKEW * 2 + 1) - SKEW
        x += moveX
        y += moveY
        canvas.setImage(x, y, fireImage)
        return canvas.getValues()
    }

    companion object {
        private const val SKEW = 10
    }
}
