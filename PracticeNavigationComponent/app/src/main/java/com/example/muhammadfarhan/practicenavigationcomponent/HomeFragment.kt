package com.example.muhammadfarhan.practicenavigationcomponent


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnKitchen.setOnClickListener {
            it.findNavController().navigate(R.id.toKitchen)
        }

        /*btnBedRoom.setOnClickListener { Navigation.createNavigateOnClickListener(R.id.toBedroom) }*/

        btnBedRoom.setOnClickListener {
            it.findNavController().navigate(R.id.toBedroom)
        }

    }
}
