package com.example.roomapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
class User(
    @PrimaryKey(autoGenerate = true) //id will be auto generate
    val id: Int,

    val firstName: String,

    val lastName: String,

    val age: Int
) {
}