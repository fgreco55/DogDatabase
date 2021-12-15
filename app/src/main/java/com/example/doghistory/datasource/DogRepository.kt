package com.example.doghistory.datasource

import androidx.lifecycle.LiveData
import com.example.doghistory.database.DogDao
import com.example.doghistory.database.DogModel

class DogRepository(private val dogDao: DogDao) {
    suspend fun insertDog(dogModel: DogModel) = dogDao.insertDog(dogModel)
    suspend fun updateDog(dogModel: DogModel) = dogDao.updateDog(dogModel)
    suspend fun deleteDog(dogModel: DogModel) = dogDao.deleteDog(dogModel)
    fun getAllDogs(): LiveData<List<DogModel>> = dogDao.getAllDogs()
}