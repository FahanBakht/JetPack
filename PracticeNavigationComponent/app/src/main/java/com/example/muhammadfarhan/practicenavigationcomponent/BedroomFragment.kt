package com.example.muhammadfarhan.practicenavigationcomponent

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_bedroom.*


class BedroomFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_bedroom, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnBedRoomGoToDoor.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("fromWhere", tvBedroom.text.toString())
            it.findNavController().navigate(R.id.bedRoomToDoor,bundle)
        }
    }

}
