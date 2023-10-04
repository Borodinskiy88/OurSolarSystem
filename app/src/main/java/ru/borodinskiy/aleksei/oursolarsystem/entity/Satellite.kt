package ru.borodinskiy.aleksei.oursolarsystem.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "satellite")
data class Satellite(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "planet") val planet: String,
    @ColumnInfo(name = "rus_name") val rusName: String,
    @ColumnInfo(name = "eng_name") val engName: String,
    @ColumnInfo(name = "min_temp") val minTemp: Int,
    @ColumnInfo(name = "max_temp") val maxTemp: Int,
    @ColumnInfo(name = "size") val size: Int,
    @ColumnInfo(name = "interesting_fact") val fact: String,
    @ColumnInfo(name = "info") val info: String,
    @ColumnInfo(name = "named_after_whom") val namedAfter: String,
    @ColumnInfo(name = "eng_planet") val engPlanet: String,
)
