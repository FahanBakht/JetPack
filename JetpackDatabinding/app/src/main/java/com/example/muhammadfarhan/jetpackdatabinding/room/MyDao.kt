package com.example.muhammadfarhan.jetpackdatabinding.room

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.muhammadfarhan.jetpackdatabinding.model.MyModel


@Dao
interface MyDao {
    @Query("SELECT * FROM my_model")
    fun loadAllData(): LiveData<List<MyModel>>

    @Insert
    fun insertValue(myModel: MyModel)

}