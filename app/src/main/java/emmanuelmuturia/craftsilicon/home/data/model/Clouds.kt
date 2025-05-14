package emmanuelmuturia.craftsilicon.home.data.model

import emmanuelmuturia.craftsilicon.home.source.local.entity.CloudsEntity

data class Clouds(
    val all: Int
)

fun CloudsEntity.toClouds(): Clouds {
    return Clouds(
        all = all
    )
}