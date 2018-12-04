package com.example.muhammadfarhan.jetpackdatabinding.architecture

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.util.Log
import com.example.muhammadfarhan.jetpackdatabinding.model.MyModel
import com.example.muhammadfarhan.jetpackdatabinding.repository.MyRepository
import com.example.muhammadfarhan.jetpackdatabinding.room.AppDatabase
import org.jetbrains.anko.doAsync

private const val TAG = "mMainViewModel"

class mMainViewModel(application: Application) : AndroidViewModel(application) {

    var valueLiveDataList: LiveData<List<MyModel>>
    private var myRepository: MyRepository

    init {
        val myDao = AppDatabase.getDatabase(application).myDao()
        myRepository = MyRepository(myDao)
        valueLiveDataList = myRepository.mListLiveData
    }

    fun saveDataAsync(myModel: MyModel) {
        doAsync {
            myRepository.insert(myModel)
            Log.e(TAG, "saveDataAsync Runs")
        }
    }


}