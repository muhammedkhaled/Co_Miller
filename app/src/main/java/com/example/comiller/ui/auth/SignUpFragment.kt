package com.example.comiller.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.example.comiller.*
import com.example.comiller.data.cash.UserPreferences
import com.example.comiller.data.network.RemoteDataSource
import com.example.comiller.data.network.interfaces.AuthApi
import com.example.comiller.data.network.response.Register
import com.example.comiller.databinding.FragmentSignUpBinding
import com.example.comiller.repository.AuthRepository
import com.example.comiller.ui.home.HomeActivity
import com.example.comiller.viewModels.AuthViewModel
import kotlinx.coroutines.launch
import net.aqua_waterfliter.jo.confirmation.data.network.ResultWrapper

class SignUpFragment : Fragment(R.layout.fragment_sign_up) {

    private lateinit var binding: FragmentSignUpBinding
    private lateinit var viewModel: AuthViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSignUpBinding.bind(view)
        binding.loadingProgress.visible(false)

        binding.registerBtn.setOnClickListener(1000L) {
            register()
        }

        val dataSource = RemoteDataSource()
        val api = dataSource.buildApi(AuthApi::class.java)
        val repository = AuthRepository(api, UserPreferences(requireContext()))
        viewModel = AuthViewModel(repository)

        viewModel.registerResponse.observe(viewLifecycleOwner, Observer {
            binding.loadingProgress.visible(it is ResultWrapper.Loading)
            binding.registerBtn.enable(it !is ResultWrapper.Loading)
            when (it) {
                is ResultWrapper.Success -> {
                    binding.root.snackbar("Account created successfully")
                    requireActivity().startNewActivity(HomeActivity::class.java)
                    lifecycleScope.launch {
                        viewModel.saveAccessTokens(
                            it.value.message,
                            it.value.data.user.email,
                            it.value.data.user.name,
                            it.value.data.user.phone,
                        )
                    }                }
                is ResultWrapper.GenericError -> handleApiError(
                    it,
                    retry = { register() },
                    root = binding.root.rootView
                )
            }
        })
    }

    private fun register() {
        val name = binding.regisVolNameEt.text.toString()
        val email = binding.regisEmailEt.text.toString()
        val phone = binding.regisVolPhoneEt.text.toString()
        val pass = binding.regisVolPassEt.text.toString()

        when {
            name.isEmpty() -> {
                binding.regisVolNameEt.error = "please write your name"
                binding.regisVolNameEt.requestFocus()
            }
            email.isEmpty() -> {
                binding.regisEmailEt.error = "please write your email"
                binding.regisEmailEt.requestFocus()
            }
            phone.isEmpty() -> {
                binding.regisVolPhoneEt.error = "please write your phone"
                binding.regisVolPhoneEt.requestFocus()
            }
            pass.isEmpty() -> {
                binding.regisVolPassEt.error = "please write your password"
                binding.regisVolPassEt.requestFocus()
            }
            else -> {
                viewModel.register(Register(name, email, phone, pass))
            }
        }
    }

}