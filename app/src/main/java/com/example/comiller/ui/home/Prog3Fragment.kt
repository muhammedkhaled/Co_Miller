package com.example.comiller.ui.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.comiller.*
import com.example.comiller.data.cash.UserPreferences
import com.example.comiller.data.network.RemoteDataSource
import com.example.comiller.data.network.interfaces.HomeApi
import com.example.comiller.data.network.response.Program3
import com.example.comiller.databinding.FragmentProg3Binding
import com.example.comiller.repository.HomeRepository
import com.example.comiller.viewModels.HomeViewModel
import com.example.comiller.viewModels.ResultViewModel
import net.aqua_waterfliter.jo.confirmation.data.network.ResultWrapper

class Prog3Fragment : Fragment(R.layout.fragment_prog3) {

    private lateinit var binding: FragmentProg3Binding
    private lateinit var viewModel: HomeViewModel
    private val resultViewModel: ResultViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProg3Binding.bind(view)
        binding.loadingProgress.visible(false)

        val dataSource = RemoteDataSource()
        val api = dataSource.buildApi(HomeApi::class.java)
        val repository = HomeRepository(api, UserPreferences(requireContext()))
        viewModel = HomeViewModel(repository)

        viewModel.programTest.observe(viewLifecycleOwner, Observer {
            binding.loadingProgress.visible(it is ResultWrapper.Loading)
            binding.prog3SubmetBtn.enable(it !is ResultWrapper.Loading)

            when (it) {
                is ResultWrapper.Success -> {
                    Log.d(ResultFragment.TAG, "program list: ${it.value.data[5]}")

//                    jsonList = Json.encodeToString(it.value.data)
//                    Log.d(ResultFragment.TAG, "program list: ${jsonList}")

                    resultViewModel.setResultData(it.value)
                    findNavController().navigate(
                        R.id.prog1ResultFragment
                    )
                }
                is ResultWrapper.GenericError -> handleApiError(
                    it,
                    retry = { register() },
                    root = binding.root.rootView
                )
            }
        })

        binding.prog3SubmetBtn.setOnClickListener(1000L) {
            register()
        }
    }

    private fun register() {
        val PanBread = binding.PanBreadEt.text.toString()
        val CrumbGrain = binding.CrumbGrainEt.text.toString()
        val LoafVolume = binding.LoafVolumeEt.text.toString()

        val error = "please insert valid input"

        when {
            PanBread.isEmpty() -> {
                binding.PanBreadEt.error = error
                binding.PanBreadEt.requestFocus()
            }
            CrumbGrain.isEmpty() -> {
                binding.CrumbGrainEt.error = error
                binding.CrumbGrainEt.requestFocus()
            }
            LoafVolume.isEmpty() -> {
                binding.LoafVolumeEt.error = error
                binding.LoafVolumeEt.requestFocus()
            }

            else -> {
                viewModel.program3(Program3(PanBread, CrumbGrain, LoafVolume))
            }
        }
    }
}