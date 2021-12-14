package com.example.dogdatabase.datasource

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.dogdatabase.database.DogDatabase
import com.example.dogdatabase.database.DogModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: DogRepository
    private var readAll: LiveData<List<DogModel>>

    init {
        val dogDB = DogDatabase.getDatabase(application).dogDao()
        repository = DogRepository(dogDB)
        readAll = repository.getAllDogs()
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

}