package com.bebooo43.cv.main.work

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Work(
    val title: String,
    val position: String,
    val duration: String,
    val imageResId: Int
) : Parcelable