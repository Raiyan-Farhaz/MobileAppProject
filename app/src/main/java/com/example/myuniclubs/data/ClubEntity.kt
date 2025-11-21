package com.example.myuniclubs.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "clubs")
data class ClubEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val category: String,
    val description: String,
    val saved: Boolean = false      // for favourites
)

