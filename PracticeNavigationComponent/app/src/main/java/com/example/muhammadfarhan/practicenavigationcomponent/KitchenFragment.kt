package com.example.muhammadfarhan.practicenavigationcomponent


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_kitchen.*


class KitchenFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kitchen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnKitchenGoToDoor.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("fromWhere", tvKitchen.text.toString())
            //it.findNavController().navigate(R.id.kitchenToDoor,bundle)

            val action = KitchenFragmentDirections.kitchenToDoor()
            action.setSafeArgs("SafeArg Practice")
            it.findNavController().navigate(action)

        }
    }

}
