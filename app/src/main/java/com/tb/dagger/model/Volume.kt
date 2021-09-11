package com.tb.dagger.model


import androidx.annotation.Keep

@Keep
data class Volume(
    val unit: String?,
    val value: Int?
)