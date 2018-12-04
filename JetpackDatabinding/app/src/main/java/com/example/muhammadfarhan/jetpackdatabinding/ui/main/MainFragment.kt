package com.example.muhammadfarhan.jetpackdatabinding.ui.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.muhammadfarhan.jetpackdatabinding.R
import com.example.muhammadfarhan.jetpackdatabinding.architecture.mMainViewModel
import com.example.muhammadfarhan.jetpackdatabinding.databinding.MainFragmentBinding
import com.example.muhammadfarhan.jetpackdatabinding.model.MyModel
import kotlinx.android.synthetic.main.main_fragment.*

private const val TAG = "MainFragment"

class MainFragment : Fragment() {

    private lateinit var binding: MainFragmentBinding
    //private lateinit var etEnterText: EditText
    private lateinit var viewModel: mMainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        //return inflater.inflate(R.layout.main_fragment, container, false)

        //binding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, null, false)
        binding = MainFragmentBinding.inflate(inflater, container, false)
        //binding.setLifecycleOwner(this)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //val customViewModel = CustomViewModelFactory(context!!)
        // viewModel = ViewModelProviders.of(this, customViewModel).get(MainViewModel::class.java)

        viewModel = ViewModelProviders.of(this).get(mMainViewModel::class.java)

        binding.btnInsert.setOnClickListener {
            if (!binding.etEnterText.text.isNullOrEmpty()) {
                val newValue = MyModel(etEnterText.text.toString())
                viewModel.saveDataAsync(newValue)
                binding.etEnterText.text.clear()

            } else {
                binding.etEnterText.error = "Please insert correct value"
            }
        }

        binding.fabNext.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_mainFragment_to_demoNavigation)
        }

        viewModel.valueLiveDataList.observe(this, Observer {
            Log.e(TAG, "getAllData?.observe Runs")
            Log.e(TAG, "getAllData?.observe Runs ${it?.size}")
            //tvTextToShow.text = it?.last()?.value
            if (!it.isNullOrEmpty()) {
                //tvTextToShow.text = it[it.size - 1].value
                binding.myModel = it[it.size - 1]
            }
        })

        /* viewModel.valueLiveDataList?.observe(this, Observer<List<MyModel>> {
             Log.e(TAG,"${it?.size}")
             if (!it.isNullOrEmpty()) {
                 Log.e(TAG,"getAllData?.observe Runs")
                 tvTextToShow.text = it.last().value
                 //binding.tvTextToShow.text = it[it.lastIndex].toString()
             }
         })*/
    }

}
