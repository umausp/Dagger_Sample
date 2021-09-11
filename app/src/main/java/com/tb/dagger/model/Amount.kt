package com.tb.dagger.model


import androidx.annotation.Keep

@Keep
data class Amount(
    val unit: String?,
    val value: Int?
)