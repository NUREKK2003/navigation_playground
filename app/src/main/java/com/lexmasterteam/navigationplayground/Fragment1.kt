package com.lexmasterteam.navigationplayground

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.lexmasterteam.navigationplayground.databinding.Fragment1Binding


class Fragment1 : Fragment() {
    private lateinit var binding: Fragment1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  Fragment1Binding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // navigacja be safeargsów
        //binding.fragment1TV.setOnClickListener { Navigation.findNavController(view).navigate(R.id.action_fragment1_to_fragment2) }

        // a tak się to robi z safeargsami
        binding.fragment1TV.setOnClickListener {
            val action = Fragment1Directions.actionFragment1ToFragment2(123)
            Navigation.findNavController(view).navigate(action) }
    }


}