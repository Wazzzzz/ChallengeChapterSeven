package com.example.challengechapterfive.mvvm

import androidx.lifecycle.*
import com.example.challengechapterfive.datastore.LogedDataStoreManager
import kotlinx.coroutines.launch


class LogedViewModel(private val pref: LogedDataStoreManager) : ViewModel() {
    val email = MutableLiveData<String>()

    fun saveData(email: String) {
        viewModelScope.launch {
            pref.saveDataLoged(email)
        }
    }

    fun checkLogin(): LiveData<Boolean> {
        return pref.getLogin().asLiveData()
    }

    fun getEmail(): LiveData<String> {
        return pref.getEmail().asLiveData()
    }

    fun clearData() {
        viewModelScope.launch {
            pref.clearData()
        }
    }

}
