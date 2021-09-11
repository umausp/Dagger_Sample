package com.tb.dagger.model


import androidx.annotation.Keep

@Keep
data class Hop(
    val add: String?,
    val amount: Amount?,
    val attribute: String?,
    val name: String?
)