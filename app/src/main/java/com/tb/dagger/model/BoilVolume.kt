package com.tb.dagger.model


import androidx.annotation.Keep

@Keep
data class BoilVolume(
    val unit: String?,
    val value: Int?
)