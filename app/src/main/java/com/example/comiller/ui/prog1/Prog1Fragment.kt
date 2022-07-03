package com.example.comiller.ui.prog1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.comiller.R
import com.example.comiller.databinding.FragmentProg1Binding
import com.example.comiller.setOnClickListener
import com.example.comiller.viewModels.HomeViewModel

class Prog1Fragment : Fragment(R.layout.fragment_prog1) {

    private lateinit var binding: FragmentProg1Binding
    private lateinit var viewModel: HomeViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProg1Binding.bind(view)

        binding.prog1SubmetBtn.setOnClickListener{
            findNavController().navigate(
                R.id.prog1ResultFragment
            )
        }
    }
}