package com.tb.dagger.model


import androidx.annotation.Keep

@Keep
data class Malt(
    val amount: AmountX?,
    val name: String?
)