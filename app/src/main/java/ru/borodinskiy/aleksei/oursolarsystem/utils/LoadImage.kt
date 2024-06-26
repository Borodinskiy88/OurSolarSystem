package ru.borodinskiy.aleksei.oursolarsystem.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation
import ru.borodinskiy.aleksei.oursolarsystem.R

fun ImageView.load(url: String, vararg transforms: BitmapTransformation = emptyArray()) =
    Glide.with(this)
        .load(url)
        .error(R.drawable.ic_error_24)
//        .placeholder(R.drawable.ic_load_24)
//        .timeout(10_000)
        .transform(*transforms)
        .into(this)


fun ImageView.loadHttps(url: String, vararg transforms: BitmapTransformation = emptyArray()) =
    Glide.with(this)
        .load("https://$url")
        .error(R.drawable.ic_error_24)
//        .placeholder(R.drawable.ic_load_24)
//        .timeout(10_000)
        .transform(*transforms)
        .into(this)