package com.example.roomapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomapp.data.User
import com.example.roomapp.data.UserDatabase
import com.example.roomapp.data.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application): AndroidViewModel(application) {

    private val readAllData: LiveData<List<User>>
    private val repository: UserRepository

    init {
        val userDao = UserDatabase.getDatabase(application).userDao()
        repository = UserRepository(userDao)

        readAllData = userDao.readAll()
    }

    fun addUser(user: User){
        viewModelScope.launch(Dispatchers.IO) { //this code will be run in the background thread
            repository.addUser(user)
        }

    }

}