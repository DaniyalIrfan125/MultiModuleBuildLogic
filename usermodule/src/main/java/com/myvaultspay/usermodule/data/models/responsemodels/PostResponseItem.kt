package com.myvaultspay.usermodule.data.models.responsemodels


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "posts")
data class PostsResponseItem(
    val body: String,

    @PrimaryKey
    val id: Int,
    val title: String,
    val userId: Int
)