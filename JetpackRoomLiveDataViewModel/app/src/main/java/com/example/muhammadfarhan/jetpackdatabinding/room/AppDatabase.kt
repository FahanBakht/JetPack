package com.example.muhammadfarhan.jetpackdatabinding.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.muhammadfarhan.jetpackdatabinding.model.MyModel


private val LOCK = Object()
private const val DATABASE_NAME = "myDataBase"

@Database(entities = [MyModel::class], version = 6, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    companion object {

        /* @Volatile
         private var sInstance: AppDatabase? = null

         fun getInstance(context: Context): AppDatabase? {
             if (sInstance == null) {
                 synchronized(LOCK) {
                     sInstance = Room.databaseBuilder(
                         context.applicationContext,
                         AppDatabase::class.java,
                         DATABASE_NAME
                     )
                         .build()
                 }
             }
             return sInstance
         }*/

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(
            context: Context
        ): AppDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    DATABASE_NAME
                )
                    .allowMainThreadQueries()
                    // Wipes and rebuilds instead of migrating if no Migration object.
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }

    abstract fun myDao(): MyDao
}