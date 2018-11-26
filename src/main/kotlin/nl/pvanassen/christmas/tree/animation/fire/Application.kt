package nl.pvanassen.christmas.tree.animation.fire

import io.micronaut.runtime.Micronaut

object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("nl.pvanassen.christmas.tree.animation.fire.animation",
                        "nl.pvanassen.christmas.tree.animation.fire.controller")
                .mainClass(Application.javaClass)
                .start()
    }
}