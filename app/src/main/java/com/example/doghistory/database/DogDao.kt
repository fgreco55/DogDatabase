package com.example.doghistory.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface DogDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE) fun insertDog(dogModel: DogModel)

    @Update(onConflict = OnConflictStrategy.IGNORE) fun updateDog(dogModel: DogModel)

    @Delete fun deleteDog(dogModel: DogModel)

    @Query("select * from dog_table")
    fun getAllDogs(): LiveData<List<DogModel>>
}