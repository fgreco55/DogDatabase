package com.example.doghistory.ui.main

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.example.doghistory.database.DogDatabase
import com.example.doghistory.database.DogModel
import com.example.doghistory.datasource.DogRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: DogRepository

   init {
       val dogdatabase = Room.databaseBuilder(
           application.applicationContext,
           DogDatabase::class.java, "dog_database"
       ).build()
       val dogDB = dogdatabase.dogDao()
       repository = DogRepository(dogDB)
    }

    fun addDog(dog: DogModel) {
        viewModelScope.launch(Dispatchers.IO) {
            Log.i("Frank", "Adding $dog to the table")
            repository.insertDog(dog)
        }
    }

    fun updateDog(dog: DogModel) {
        viewModelScope.launch(Dispatchers.IO) {
            Log.i("Frank", "Updating $dog in the table")
            repository.updateDog(dog)
        }
    }

    fun deleteDog(dog: DogModel) {
        viewModelScope.launch(Dispatchers.IO) {
            Log.i("Frank", "Deleting $dog from the table")
            repository.deleteDog(dog)
        }
    }

    fun getAllDogs() {
        viewModelScope.launch(Dispatchers.IO) {
            Log.i("Frank", "Getting all the Dogs from the table")
            repository.getAllDogs()
        }
    }

}
