package com.noir.studentapp.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Student(
    val image: String,
    val nama: String,
    val nim: String
) : Parcelable