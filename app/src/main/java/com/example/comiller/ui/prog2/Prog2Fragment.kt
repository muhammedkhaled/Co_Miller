package com.example.comiller.ui.prog2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.comiller.R
import com.example.comiller.databinding.FragmentProg1Binding
import com.example.comiller.databinding.FragmentProg2Binding
import com.example.comiller.viewModels.HomeViewModel

class Prog2Fragment : Fragment(R.layout.fragment_prog2) {

    private lateinit var binding: FragmentProg2Binding
    private lateinit var viewModel: HomeViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProg2Binding.bind(view)

        binding.prog2SubmetBtn.setOnClickListener{
            findNavController().navigate(
                R.id.prog1ResultFragment
            )
        }

    }

}