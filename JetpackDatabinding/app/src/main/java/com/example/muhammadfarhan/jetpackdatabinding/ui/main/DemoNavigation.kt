package com.example.muhammadfarhan.jetpackdatabinding.ui.main


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.muhammadfarhan.jetpackdatabinding.R
import kotlinx.android.synthetic.main.fragment_demo_navigation.*

private const val TAG = "DemoNavigation"
private const val KEY_VALUE_FROM = "valueFrom"

class DemoNavigation : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_demo_navigation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Navigation using Bundle
        btnNextWithBundle.setOnClickListener {
            val bundle = Bundle().apply {
                putString(KEY_VALUE_FROM, "Comes With Bundle")
            }
            Navigation.findNavController(it).navigate(R.id.action_demoNavigation_to_demoSafeArgs, bundle)
        }

        // Navigation using SafeArgs
        btnNextWithSafeArgs.setOnClickListener {
            val action = DemoNavigationDirections.actionDemoNavigationToDemoSafeArgs()
            action.setValueFrom("Comes With SafeArgs")
            it.findNavController().navigate(action)
        }
    }


}
