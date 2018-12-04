package com.example.muhammadfarhan.jetpackdatabinding.repository

import android.arch.lifecycle.LiveData
import com.example.muhammadfarhan.jetpackdatabinding.model.MyModel
import com.example.muhammadfarhan.jetpackdatabinding.room.MyDao


private const val TAG = "MyRepository"

class MyRepository(private val myDao: MyDao) {

    var mListLiveData: LiveData<List<MyModel>> = myDao.loadAllData()

     fun insert(myModel: MyModel) {
        myDao.insertValue(myModel)
    }

    /*private var appDatabase: AppDatabase? = null

     var mListLiveData: LiveData<List<MyModel>>? = null

    private object SingletonHelper {
        val INSTANCE = MyRepository()
    }

    fun getInstance(context: Context): MyRepository {
        appDatabase = AppDatabase.getInstance(context)
        Log.e(TAG, "getInstance Runs")
        mListLiveData = appDatabase?.myDao()?.loadAllData()
        return MyRepository.SingletonHelper.INSTANCE
    }

    fun saveDataAsync(myModel: MyModel) {
        doAsync {
            appDatabase?.myDao()!!.insertValue(myModel)
            Log.e(TAG, "saveDataAsync Runs")
        }
    }

    fun getAllDataAsync(): LiveData<List<MyModel>>? {
       doAsync {
           val mListLiveData = appDatabase?.myDao()?.loadAllData()
           Log.e(TAG,"getAllDataAsync Runs")
           uiThread {
               it.mListLiveData = mListLiveData
               Log.e(TAG,"getAllDataAsync doAsync Runs")
           }
       }.get()
       return mListLiveData
   }*/

}