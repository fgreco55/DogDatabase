package com.example.dogdatabase.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface DogDao {
    @Insert
    suspend fun insertDog(dogModel: DogModel)

    @Update
    suspend fun updateDog(dogModel: DogModel)

    @Query("select * from dog_table")
    fun getAllDogs(): LiveData<List<DogModel>>
}