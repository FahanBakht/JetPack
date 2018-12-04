package com.example.muhammadfarhan.practicenavigationcomponent


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_home_door.*


class HomeDoorFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_door, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //tvToShow.text = arguments?.getString("fromWhere")
        tvToShow.text = arguments?.getString("safeArgs")


        btnGoToHome.setOnClickListener {
            it.findNavController().navigate(R.id.toHome)
        }
    }

}
