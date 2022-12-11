package nl.pvanassen.led.animation.fire

import nl.pvanassen.led.animation.common.model.Animation
import nl.pvanassen.led.animation.common.util.CommonUtils
import nl.pvanassen.christmas.tree.canvas.Canvas
import java.awt.image.BufferedImage
import java.io.IOException
import java.io.UncheckedIOException
import javax.imageio.ImageIO
import kotlin.math.max
import kotlin.math.min

class Fire(private val canvas: Canvas) : Animation<Any> {

    private val fireImage: BufferedImage

    private var x: Int = 0

    init {
        try {
            fireImage = ImageIO.read(javaClass.getResourceAsStream("/fire2.png"))
        } catch (e: IOException) {
            throw UncheckedIOException(e)
        }
        x = -(fireImage.width / 2)
    }

    override fun getFrame(seed: Long, frame: Int, nsPerFrame: Int, helper: Any): ByteArray {
        val moveX = CommonUtils.getRandom(SKEW * 2 + 1) - SKEW
        x += moveX
        x = max(0, x)
        x = min(fireImage.width - canvas.canvas.width, x)
        canvas.setImage(x, 0, fireImage)
        return canvas.getValues()
    }

    companion object {
        private const val SKEW = 5
    }
}
