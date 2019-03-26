package com.example.muhammadfarhan.jetpackdatabinding.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.muhammadfarhan.jetpackdatabinding.model.MyModel


private val LOCK = Object()
private const val DATABASE_NAME = "myDataBase"

@Database(entities = [MyModel::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        private var sInstance: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase? {
            if (sInstance == null) {
                synchronized(LOCK) {
                    sInstance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java, DATABASE_NAME
                    )
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return sInstance
        }
    }

    abstract fun myDao(): MyDao
}