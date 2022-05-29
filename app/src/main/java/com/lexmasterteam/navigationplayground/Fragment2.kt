package com.lexmasterteam.navigationplayground

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.lexmasterteam.navigationplayground.databinding.Fragment2Binding


class Fragment2 : Fragment() {

    // ta lista przechowuje argumenty (komunikacja z innymi fragmentami po prostu)
    val args: Fragment2Args by navArgs()
    private lateinit var binding: Fragment2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = Fragment2Binding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val myNumbers = args.num2
        binding.fragment2TV.text = myNumbers.toString()
    }


}