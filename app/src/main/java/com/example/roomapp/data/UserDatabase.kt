package com.example.roomapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [User::class],
    version = 1,
    exportSchema = false
)
abstract class UserDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        var INSTANCE: UserDatabase? = null

        @Synchronized
        fun getDatabase(context: Context): UserDatabase {
            if (INSTANCE == null) {

                INSTANCE = Room.databaseBuilder(
                    context,
                    UserDatabase::class.java, "user_database")
                    .build()

            }
            return INSTANCE!!
        }

    }

}