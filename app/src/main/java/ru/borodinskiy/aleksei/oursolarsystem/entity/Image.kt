package ru.borodinskiy.aleksei.oursolarsystem.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "images")
data class Image (
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "key_word") val keyWord: String,
    @ColumnInfo(name = "url") val url: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "date") val date: String,
    @ColumnInfo(name = "info") val info: String,

    //Todo в базе Int
    @ColumnInfo(name = "favorite")
    val favorite: Boolean = false
)