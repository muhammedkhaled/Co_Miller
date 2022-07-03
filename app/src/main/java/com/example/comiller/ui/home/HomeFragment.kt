package com.example.comiller.ui.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.comiller.R
import com.example.comiller.databinding.FragmentHomeBinding
import com.example.comiller.setOnClickListener

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)

        binding.prog1Cardv.setOnClickListener(1000L){
            findNavController().navigate(R.id.nav_prog1)
        }

        binding.prog2Cardv.setOnClickListener(1000L){
            findNavController().navigate(R.id.nav_prog2)
        }

        binding.prog3Cardv.setOnClickListener(1000L){
            findNavController().navigate(R.id.nav_prog3)
        }
    }

}