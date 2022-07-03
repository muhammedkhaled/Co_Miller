package com.example.comiller.ui.prog1

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.comiller.*
import com.example.comiller.data.cash.UserPreferences
import com.example.comiller.data.network.RemoteDataSource
import com.example.comiller.data.network.interfaces.HomeApi
import com.example.comiller.data.network.response.Data
import com.example.comiller.data.network.response.Program1
import com.example.comiller.databinding.FragmentProg1Binding
import com.example.comiller.repository.HomeRepository
import com.example.comiller.ui.ResultFragment
import com.example.comiller.ui.ResultFragment.Companion.TAG
import com.example.comiller.viewModels.HomeViewModel
import net.aqua_waterfliter.jo.confirmation.data.network.ResultWrapper

import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString

class Prog1Fragment : Fragment(R.layout.fragment_prog1) {

    private lateinit var binding: FragmentProg1Binding
    private lateinit var viewModel: HomeViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProg1Binding.bind(view)

        binding.loadingProgress.visible(false)

        val dataSource = RemoteDataSource()
        val api = dataSource.buildApi(HomeApi::class.java)
        val repository = HomeRepository(api, UserPreferences(requireContext()))
        viewModel = HomeViewModel(repository)

        viewModel.programTest.observe(viewLifecycleOwner, Observer {
            binding.loadingProgress.visible(it is ResultWrapper.Loading)
            binding.prog1SubmetBtn.enable(it !is ResultWrapper.Loading)

            when (it) {
                is ResultWrapper.Success -> {
                    /*findNavController().navigate(
                        R.id.prog1ResultFragment
                    )*/
                    Log.d(TAG, "program list: ${it.value.data[5]}")

                    val jsonList = Json.encodeToString(it.value.data)
                    Log.d(TAG, "program list: ${jsonList}")
//                    Toast.makeText(requireContext(), "${jsonList}", Toast.LENGTH_SHORT).show()
//                    val obj = Json.decodeFromString<List<Data>>(jsonList!!)
//                    Toast.makeText(requireContext(), "${obj[5]}", Toast.LENGTH_SHORT).show()
//                    Log.d(TAG, "program list: ${obj[5]}")

                    ResultFragment.newInstance(jsonList)
                }
                is ResultWrapper.GenericError -> handleApiError(
                    it,
                    retry = { register() },
                    root = binding.root.rootView
                )
            }
        })

        binding.prog1SubmetBtn.setOnClickListener(1000L) {
            register()
        }
    }

    private fun register() {
        val Moisture = binding.MoistureEt.text.toString()
        val Protein = binding.ProteinEt.text.toString()
        val Ash = binding.AshEt.text.toString()
        val WetGluten = binding.WetGlutenEt.text.toString()
        val GlutenIndex = binding.GlutenIndexEt.text.toString()

        val error = "please insert valid input"

        when {
            Moisture.isEmpty() -> {
                binding.MoistureEt.error = error
                binding.MoistureEt.requestFocus()
            }
            Protein.isEmpty() -> {
                binding.ProteinEt.error = error
                binding.ProteinEt.requestFocus()
            }
            Ash.isEmpty() -> {
                binding.AshEt.error = error
                binding.AshEt.requestFocus()
            }
            WetGluten.isEmpty() -> {
                binding.WetGlutenEt.error = error
                binding.WetGlutenEt.requestFocus()
            }
            GlutenIndex.isEmpty() -> {
                binding.GlutenIndexEt.error = error
                binding.GlutenIndexEt.requestFocus()
            }

            else -> {
                viewModel.program1(Program1(Moisture, Protein, Ash, WetGluten, GlutenIndex))
            }
        }
    }
}