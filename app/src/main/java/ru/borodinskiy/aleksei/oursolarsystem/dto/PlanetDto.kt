package ru.borodinskiy.aleksei.oursolarsystem.dto

data class PlanetDto(
    val id: Int,
    val rusName: String,
    val latinName: String,
    val solidSurface: Boolean = false,
    val minTemp: Int,
    val maxTemp: Int,
    val countSatellites: Int,
    val size: Double,
    val gravity: Double,
    val durationYear: String,
    val durationDay: Double,
    val fact: String,
    val info: String,
    val appearance: String,
    val rings: String? = null,
    val terraform: String? = null
)