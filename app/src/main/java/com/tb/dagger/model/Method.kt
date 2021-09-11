package com.tb.dagger.model


import androidx.annotation.Keep

@Keep
data class Method(
    val fermentation: Fermentation?,
    val mash_temp: List<MashTemp>?,
    val twist: String?
)