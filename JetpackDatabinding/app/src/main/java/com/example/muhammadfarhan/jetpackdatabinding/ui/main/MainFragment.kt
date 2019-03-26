package com.example.muhammadfarhan.jetpackdatabinding.ui.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.navigation.Navigation
import com.example.muhammadfarhan.jetpackdatabinding.R
import com.example.muhammadfarhan.jetpackdatabinding.architecture.CustomViewModelFactory
import com.example.muhammadfarhan.jetpackdatabinding.architecture.MainViewModel
import com.example.muhammadfarhan.jetpackdatabinding.databinding.MainFragmentBinding
import com.example.muhammadfarhan.jetpackdatabinding.model.MyModel

class MainFragment : Fragment() {

    private lateinit var binding: MainFragmentBinding
    private lateinit var etEnterText: EditText
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //return inflater.inflate(R.layout.main_fragment, container, false)

        binding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, null, false)
        binding.setLifecycleOwner(this)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        val customViewModel = CustomViewModelFactory(context!!)
        viewModel = ViewModelProviders.of(this, customViewModel).get(MainViewModel::class.java)

        binding.btnInsert.setOnClickListener {
            if (!etEnterText.text.isNullOrEmpty()) {
                val newValue = MyModel(etEnterText.text.toString())
                viewModel.insertData(newValue)

            } else {
                etEnterText.error = "Please insert correct value"
            }
        }

        binding.fabNext.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_mainFragment_to_demoNavigation)
        }


        viewModel.valueLiveDataList?.observe(this, Observer<List<MyModel>> {
            if (!it.isNullOrEmpty()) {
                binding.tvTextToShow.text = it.last().value
                //binding.tvTextToShow.text = it[it.lastIndex].toString()
            }
        })
    }

}
