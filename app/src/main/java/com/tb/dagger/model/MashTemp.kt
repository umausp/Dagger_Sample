package com.tb.dagger.model


import androidx.annotation.Keep

@Keep
data class MashTemp(
    val duration: Int?,
    val temp: TempX?
)