package com.example.comiller.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import com.example.comiller.R
import com.example.comiller.data.network.response.Data
import com.example.comiller.databinding.FragmentResultBinding
import com.example.comiller.viewModels.HomeViewModel

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.decodeFromString

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"

class ResultFragment : Fragment(R.layout.fragment_result) {

    // TODO: Rename and change types of parameters
    private var param1: String? = null

    private lateinit var binding: FragmentResultBinding
    private lateinit var viewModel: HomeViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentResultBinding.bind(view)

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }

        val obj = Json.decodeFromString<List<Data>>(param1!!)
        Toast.makeText(requireContext(), "${obj[15]}", Toast.LENGTH_SHORT).show()
    }

    companion object {
        const val TAG = "CreateNewAccBtmFragment"

        @JvmStatic
        fun newInstance(param1: String) =
            ResultFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }
}