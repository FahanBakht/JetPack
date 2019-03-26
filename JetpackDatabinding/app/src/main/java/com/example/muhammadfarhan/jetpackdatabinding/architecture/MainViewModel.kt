package com.example.muhammadfarhan.jetpackdatabinding.architecture

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.content.Context
import com.example.muhammadfarhan.jetpackdatabinding.model.MyModel
import com.example.muhammadfarhan.jetpackdatabinding.repository.MyRepository

class MainViewModel(context:Context) : ViewModel() {

    var valueLiveDataList: LiveData<List<MyModel>>? = null
    private var myRepository: MyRepository? = null

    init {
        myRepository = MyRepository().getInstance(context)
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