package com.example.muhammadfarhan.jetpackdatabinding.architecture

import android.arch.lifecycle.ViewModel
import android.content.Context

private const val TAG = "MainViewModel"
class MainViewModel(context:Context) : ViewModel() {

   /* var valueLiveDataList: LiveData<List<MyModel>>? = null
    private var myRepository: MyRepository? = null

    init {
        Log.e(TAG,"Init Runs")
        myRepository = MyRepository().getInstance(context)
        //valueLiveDataList = myRepository?.getAllDataAsync()
        valueLiveDataList = myRepository?.mListLiveData
    }

    *//*fun getAllData(): LiveData<List<MyModel>>? {
        if (valueLiveDataList == null) {
            valueLiveDataList = myRepository!!.getAllDataAsync()
            Log.e(TAG,"getAllData if runs")
        }
        Log.e(TAG,"getAllData else runs")
        return valueLiveDataList
    }*//*

    fun insertData(myModel: MyModel) {
        myRepository!!.saveDataAsync(myModel)
        Log.e(TAG,"insertData runs")
    }*/
}