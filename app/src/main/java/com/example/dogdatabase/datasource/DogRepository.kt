package com.example.dogdatabase.datasource

import androidx.lifecycle.LiveData
import com.example.dogdatabase.database.DogDao
import com.example.dogdatabase.database.DogModel

class DogRepository(private val dogDao: DogDao) {
    suspend fun insertDog(dogModel: DogModel) = dogDao.insertDog(dogModel)
    suspend fun updateDog(dogModel: DogModel) = dogDao.updateDog(dogModel)
    fun getAllDogs(): LiveData<List<DogModel>> = dogDao.getAllDogs()
}