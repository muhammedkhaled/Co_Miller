package com.example.comiller.ui.prog3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.comiller.R
import com.example.comiller.databinding.FragmentProg3Binding
import com.example.comiller.viewModels.HomeViewModel

class Prog3Fragment : Fragment(R.layout.fragment_prog3) {

    private lateinit var binding: FragmentProg3Binding
    private lateinit var viewModel: HomeViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProg3Binding.bind(view)

        binding.prog3SubmetBtn.setOnClickListener{
            findNavController().navigate(
                R.id.prog1ResultFragment
            )
        }
    }
}