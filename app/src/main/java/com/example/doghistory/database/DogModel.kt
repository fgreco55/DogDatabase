package com.example.doghistory.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dog_table")
data class DogModel(
    @PrimaryKey val dogId: Int,

    val description: String?,    // whatever we want... maybe "previous" or "current"?
    val url: String?             // Actual URL of dog image source
)
