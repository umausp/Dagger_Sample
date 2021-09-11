package com.tb.dagger.model


import androidx.annotation.Keep

@Keep
data class BeerDataModelItem(
    val image_url: String?,
    val name: String?
)