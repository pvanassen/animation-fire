package nl.pvanassen.led.animation.fire

import nl.pvanassen.led.animation.common.canvas.Canvas
import nl.pvanassen.led.animation.common.model.Animation
import nl.pvanassen.led.animation.common.util.CommonUtils
import java.awt.Image
import java.awt.image.BufferedImage
import java.io.IOException
import java.io.UncheckedIOException
import javax.imageio.ImageIO
import javax.swing.ImageIcon
import kotlin.math.max
import kotlin.math.min

class Fire(private val canvas: Canvas) : Animation<Any> {

    private val fireImage: BufferedImage

    private val image: Image

    private var x: Int = 0

    init {
        try {
            image = ImageIcon(javaClass.getResource("Animated_fire_by_nevit.gif")).image
            fireImage = ImageIO.read(javaClass.getResourceAsStream("/fire2.png"))
        } catch (e: IOException) {
            throw UncheckedIOException(e)
        }
        x = -(fireImage.width / 2)
    }

    override fun getFrame(seed: Long, frame: Int, nsPerFrame: Int, helper: Any): ByteArray {
//        val moveX = CommonUtils.getRandom(SKEW * 2 + 1) - SKEW
//        x += moveX
//        x = max(0, x)
//        x = min(fireImage.width - canvas.getWidth(), x)
//        canvas.setImage(x, 0, fireImage)
        canvas.drawImage(image)
        return canvas.getValues()
    }

    companion object {
        private const val SKEW = 5
    }
}
