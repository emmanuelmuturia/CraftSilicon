package emmanuelmuturia.craftsilicon.home.data.model

import emmanuelmuturia.craftsilicon.home.source.local.entity.SysEntity

data class Sys(
    val country: String,
    val sunrise: Int,
    val sunset: Int
)

fun SysEntity.toSys(): Sys {
    return Sys(
        country = country,
        sunrise = sunrise,
        sunset = sunset
    )
}