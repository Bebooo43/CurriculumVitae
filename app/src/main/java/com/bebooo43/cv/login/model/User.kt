package com.bebooo43.cv.login.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val userName: String,
    val password: String
) : Parcelable
