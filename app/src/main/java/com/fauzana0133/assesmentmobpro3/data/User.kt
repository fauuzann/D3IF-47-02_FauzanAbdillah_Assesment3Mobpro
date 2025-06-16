package com.fauzana0133.assesmentmobpro3.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class User(
    val id: String,
    val name: String,
    val email: String,
    val profilePicUrl: String
)
