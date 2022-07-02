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
import com.example.comiller.databinding.FragmentProg2Binding

class Prog2Fragment : Fragment() {

    private var _binding: FragmentProg2Binding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val prog2ViewModel =
            ViewModelProvider(this).get(Prog2ViewModel::class.java)

        _binding = FragmentProg2Binding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.prog2SubmetBtn.setOnClickListener{
            findNavController().navigate(
                R.id.prog1ResultFragment
            )
        }

//        val textView: TextView = binding.textGallery
//        prog2ViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}