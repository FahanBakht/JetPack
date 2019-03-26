package com.example.muhammadfarhan.jetpackdatabinding.repository

import android.arch.lifecycle.LiveData
import android.content.Context
import com.example.muhammadfarhan.jetpackdatabinding.model.MyModel
import com.example.muhammadfarhan.jetpackdatabinding.room.AppDatabase
import android.os.AsyncTask
import android.util.Log
import org.jetbrains.anko.AnkoAsyncContext
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.doAsyncResult
import org.jetbrains.anko.uiThread
import java.util.concurrent.ExecutionException


private const val TAG = "myRepo"

class MyRepository {

    private var appDatabase: AppDatabase? = null
    private var mListLiveData: LiveData<List<MyModel>>? = null

    private object SingletonHelper {
        val INSTANCE = MyRepository()
    }

    fun getInstance(context: Context): MyRepository {
        appDatabase = AppDatabase.getInstance(context)
        return MyRepository.SingletonHelper.INSTANCE
    }

     fun saveDataAsync(myModel: MyModel) {
        doAsync {
            appDatabase?.myDao()?.insertValue(myModel)
        }
    }

     fun getAllDataAsync(): LiveData<List<MyModel>>? {
        doAsync {
            val mListLiveData = appDatabase?.myDao()?.loadAllData()
            uiThread {
                it.mListLiveData = mListLiveData
            }
        }.get()
        return mListLiveData
    }

}