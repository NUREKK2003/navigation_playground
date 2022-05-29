package com.lexmasterteam.navigationplayground

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lexmasterteam.navigationplayground.databinding.Fragment3Binding


class Fragment3 : Fragment() {

    private lateinit var binding: Fragment3Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  Fragment3Binding.inflate(inflater, container, false)
        return binding.root
    }


}