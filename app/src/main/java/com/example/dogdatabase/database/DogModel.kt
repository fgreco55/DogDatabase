package com.example.dogdatabase.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dog_table")
data class DogModel(
    @PrimaryKey(autoGenerate = true)
    val dogId: Int?,

    @ColumnInfo()                   // @ColumnInfo not necessary if using same column name as in the DB
    val description: String,        // whatever we want... maybe "previous" or "current"?

    @ColumnInfo
    val url: String                 // Actual URL of dog image source
)
