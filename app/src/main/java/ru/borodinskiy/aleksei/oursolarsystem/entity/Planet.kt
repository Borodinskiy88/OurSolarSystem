package ru.borodinskiy.aleksei.oursolarsystem.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "planets_db")
data class Planet(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val rusName: String,
    @ColumnInfo(name = "latin_name") val latinName: String,
    @ColumnInfo(name = "named_after_whom") val namedAfter: String,
    @ColumnInfo(name = "solid_surface") val solidSurface: Boolean,
    @ColumnInfo(name = "min_temperature") val minTemp: Int,
    @ColumnInfo(name = "max_temperature") val maxTemp: Int,
    @ColumnInfo(name = "count_satellites") val countSatellites: Int,
    @ColumnInfo(name = "size_to_earth") val size: String,
    @ColumnInfo(name = "gravity") val gravity: String,
    @ColumnInfo(name = "duration_year") val durationYear: String,
    @ColumnInfo(name = "duration_day") val durationDay: String,
    @ColumnInfo(name = "interesting_fact") val fact: String,
    @ColumnInfo(name = "information") val info: String,
    @ColumnInfo(name = "human_appearance") val appearance: String,
    @ColumnInfo(name = "rings") val rings: String?,
    @ColumnInfo(name = "terraform") val terraform: String?
)

