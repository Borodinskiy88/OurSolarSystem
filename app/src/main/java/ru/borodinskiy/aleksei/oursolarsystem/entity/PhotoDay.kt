package ru.borodinskiy.aleksei.oursolarsystem.entity

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class PhotoDay(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @SerializedName("copyright")
    val copyright: String,
    @SerializedName("date")
    val date: String,
    @SerializedName("explanation")
    val explanation: String,
    @SerializedName("media_type")
    val mediaType: String,
    @SerializedName("service_version")
    val serviceVersion: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String
)
