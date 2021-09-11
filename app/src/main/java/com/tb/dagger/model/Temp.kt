package com.tb.dagger.model


import androidx.annotation.Keep

@Keep
data class Temp(
    val unit: String?,
    val value: Int?
)