package com.example.comiller.ui.prog2

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.comiller.*
import com.example.comiller.data.cash.UserPreferences
import com.example.comiller.data.network.RemoteDataSource
import com.example.comiller.data.network.interfaces.HomeApi
import com.example.comiller.data.network.response.Program1
import com.example.comiller.data.network.response.Program2
import com.example.comiller.databinding.FragmentProg1Binding
import com.example.comiller.databinding.FragmentProg2Binding
import com.example.comiller.repository.HomeRepository
import com.example.comiller.ui.ResultFragment
import com.example.comiller.viewModels.HomeViewModel
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import net.aqua_waterfliter.jo.confirmation.data.network.ResultWrapper

class Prog2Fragment : Fragment(R.layout.fragment_prog2) {

    private lateinit var binding: FragmentProg2Binding
    private lateinit var viewModel: HomeViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProg2Binding.bind(view)
        binding.loadingProgress.visible(false)

        val dataSource = RemoteDataSource()
        val api = dataSource.buildApi(HomeApi::class.java)
        val repository = HomeRepository(api, UserPreferences(requireContext()))
        viewModel = HomeViewModel(repository)

        viewModel.programTest.observe(viewLifecycleOwner, Observer {
            binding.loadingProgress.visible(it is ResultWrapper.Loading)
            binding.prog2SubmetBtn.enable(it !is ResultWrapper.Loading)

            when (it) {
                is ResultWrapper.Success -> {
                    /*findNavController().navigate(
                        R.id.prog1ResultFragment
                    )*/
                    Log.d(ResultFragment.TAG, "program list: ${it.value.data[5]}")

                    val jsonList = Json.encodeToString(it.value.data)
                    Log.d(ResultFragment.TAG, "program list: ${jsonList}")
//                    Toast.makeText(requireContext(), "${jsonList}", Toast.LENGTH_SHORT).show()
//                    val obj = Json.decodeFromString<List<Data>>(jsonList!!)
//                    Toast.makeText(requireContext(), "${obj[5]}", Toast.LENGTH_SHORT).show()
//                    Log.d(TAG, "program list: ${obj[5]}")

//                    ResultFragment.newInstance(jsonList)
                }
                is ResultWrapper.GenericError -> handleApiError(
                    it,
                    retry = { register() },
                    root = binding.root.rootView
                )
            }
        })

        binding.prog2SubmetBtn.setOnClickListener(1000L) {
            register()
        }

    }

    private fun register() {
        val Moisture = binding.MoistureEt.text.toString()
        val KernelSize = binding.KernelSizeEt.text.toString()
        val SinglKernel = binding.SinglKernelEt.text.toString()

        val error = "please insert valid input"

        when {
            Moisture.isEmpty() -> {
                binding.MoistureEt.error = error
                binding.MoistureEt.requestFocus()
            }
            KernelSize.isEmpty() -> {
                binding.KernelSizeEt.error = error
                binding.KernelSizeEt.requestFocus()
            }
            SinglKernel.isEmpty() -> {
                binding.SinglKernelEt.error = error
                binding.SinglKernelEt.requestFocus()
            }

            else -> {
                viewModel.program2(Program2(Moisture, KernelSize, SinglKernel))
            }
        }
    }

}