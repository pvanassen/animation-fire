package nl.pvanassen.christmas.tree.animation.disco.configuration

import io.micronaut.context.annotation.Bean
import io.micronaut.context.annotation.Factory
import nl.pvanassen.christmas.tree.animation.disco.model.TreeModel
import nl.pvanassen.christmas.tree.canvas.Canvas

@Factory
class BeanFactory {

    @Bean
    fun getTreeModel() = TreeModel(16, 60)

    @Bean
    fun createCanvas(treeModel: TreeModel): Canvas {
        return Canvas(treeModel.strips, treeModel.ledsPerStrip)
    }
}