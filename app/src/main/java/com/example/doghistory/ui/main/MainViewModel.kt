package com.example.doghistory.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.doghistory.database.DogDatabase
import com.example.doghistory.database.DogModel
import com.example.doghistory.datasource.DogRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: DogRepository
    //private var readAll: LiveData<List<DogModel>>

   init {
        val dogDB = DogDatabase.getDatabase(application).dogDao()
        repository = DogRepository(dogDB)
        //readAll = repository.getAllDogs()
    }

    fun addDog(dog: DogModel) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertDog(dog)
        }
    }

    fun updateDog(dog: DogModel) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateDog(dog)
        }
    }

    fun getAllDogs() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllDogs()
        }
    }

}
