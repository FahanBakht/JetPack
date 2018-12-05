package com.example.muhammadfarhan.jetpackdatabinding.ui.main


import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.muhammadfarhan.jetpackdatabinding.R
import kotlinx.android.synthetic.main.fragment_demo_safe_args.*


private const val TAG = "DemoSafeArgs"
private const val KEY_VALUE_FROM = "valueFrom"

class DemoSafeArgs : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_demo_safe_args, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (arguments != null) {
            if (arguments!!.containsKey(KEY_VALUE_FROM)) {
                tvValueFrom.text = arguments?.getString(KEY_VALUE_FROM)
            } else {
                Log.e(TAG, "No Value Found in Arguments KEY")
            }
        } else {
            Log.e(TAG, "No Value Found in Arguments")
        }
    }


}
