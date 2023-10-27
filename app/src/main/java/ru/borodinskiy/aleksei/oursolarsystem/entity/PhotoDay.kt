package ru.borodinskiy.aleksei.oursolarsystem.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class PhotoDay(
    @SerializedName("copyright")
    val copyright: String,
    @SerializedName("date")
    @PrimaryKey
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
    val url: String,

    //todo
//    val favorite: Boolean
)
