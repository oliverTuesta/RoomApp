package com.example.roomapp.data

import androidx.lifecycle.LiveData

class UserRepository(val userDao: UserDao) {

    val readAllData: LiveData<List<User>> = userDao.readAll()

    suspend fun addUser(user: User){
        userDao.addUser(user)
    }

}