package com.tb.dagger.model


import androidx.annotation.Keep

@Keep
data class Ingredients(
    val hops: List<Hop>?,
    val malt: List<Malt>?,
    val yeast: String?
)