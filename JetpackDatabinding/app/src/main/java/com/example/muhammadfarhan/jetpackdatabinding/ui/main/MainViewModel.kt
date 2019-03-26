package com.example.muhammadfarhan.jetpackdatabinding.ui.main

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.example.muhammadfarhan.jetpackdatabinding.model.MyModel
import com.example.muhammadfarhan.jetpackdatabinding.repository.MyRepository


class MainViewModel(application: Application) : AndroidViewModel(application) {

    var valueLiveDataList: LiveData<List<MyModel>>? = null
    private var myRepository: MyRepository? = null

    init {
        myRepository = MyRepository().getInstance(getApplication())
        valueLiveDataList = myRepository?.getAllDataAsync()
    }

    fun getAllData(): LiveData<List<MyModel>>? {
        if (valueLiveDataList == null) {
            valueLiveDataList = myRepository?.getAllDataAsync()
        }
        return valueLiveDataList
    }

    fun insertData(myModel: MyModel) {
        myRepository?.saveDataAsync(myModel)
    }
}
