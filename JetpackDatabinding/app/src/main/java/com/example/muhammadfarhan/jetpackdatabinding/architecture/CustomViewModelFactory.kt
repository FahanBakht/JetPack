package com.example.muhammadfarhan.jetpackdatabinding.architecture

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.content.Context



class CustomViewModelFactory(context: Context) : ViewModelProvider.NewInstanceFactory() {

    private var mContext: Context = context

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        return MainViewModel(mContext) as T
    }
}