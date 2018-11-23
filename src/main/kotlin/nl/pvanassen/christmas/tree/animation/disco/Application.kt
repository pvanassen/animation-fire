package nl.pvanassen.christmas.tree.animation.disco

import io.micronaut.runtime.Micronaut

object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("nl.pvanassen.christmas.tree.animation.disco.animation",
                        "nl.pvanassen.christmas.tree.animation.disco.configuration",
                        "nl.pvanassen.christmas.tree.animation.disco.controller")
                .mainClass(Application.javaClass)
                .start()
    }
}