package com.fauzana0133.assesmentmobpro3.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Item(
    val id: String,
    val name: String,
    val description: String,
    val imageUrl: String,
    val userId: String
)
