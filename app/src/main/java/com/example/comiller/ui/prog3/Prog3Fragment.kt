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

class Prog3Fragment : Fragment() {

    private var _binding: FragmentProg3Binding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val prog3ViewModel =
            ViewModelProvider(this).get(Prog3ViewModel::class.java)

        _binding = FragmentProg3Binding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.prog3SubmetBtn.setOnClickListener{
            findNavController().navigate(
                R.id.prog1ResultFragment
            )
        }
//        val textView: TextView = binding.textSlideshow
//        prog3ViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}