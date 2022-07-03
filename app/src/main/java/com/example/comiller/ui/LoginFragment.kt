package com.example.comiller.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.comiller.*
import com.example.comiller.data.cash.UserPreferences
import com.example.comiller.data.network.RemoteDataSource
import com.example.comiller.data.network.interfaces.AuthApi
import com.example.comiller.data.network.response.Login
import com.example.comiller.databinding.FragmentLoginBinding
import com.example.comiller.repository.AuthRepository
import com.example.comiller.viewModels.AuthViewModel
import kotlinx.coroutines.launch
import net.aqua_waterfliter.jo.confirmation.data.network.ResultWrapper


class LoginFragment : Fragment(R.layout.fragment_login) {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var viewModel: AuthViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(view)
        binding.loadingProgress.visible(false)

        val dataSource = RemoteDataSource()
        val api = dataSource.buildApi(AuthApi::class.java)
        val repository = AuthRepository(api, UserPreferences(requireContext()))
        viewModel = AuthViewModel(repository)


        binding.loginBtn.setOnClickListener(1000L) {
            login()
        }

        view.findViewById<TextView>(R.id.signIn_tv).setOnClickListener {
            findNavController().navigate(R.id.signUpFragment)
        }

        viewModel.loginResponse.observe(viewLifecycleOwner, Observer {
            binding.loadingProgress.visible(it is ResultWrapper.Loading)
            binding.loginBtn.enable(it !is ResultWrapper.Loading)
            when (it) {
                is ResultWrapper.Success -> {
                    lifecycleScope.launch {
//                            viewModel.saveAccessTokens(
//                                it.value.Token,
//                                it.value.Email,
//                                it.value.agentNum
//                            )
                        // TODO: cash response
                    }
                    requireActivity().startNewActivity(HomeActivity::class.java)
                }
                is ResultWrapper.GenericError -> handleApiError(it, retry = { login() }, root = binding.root.rootView)
            }
        })


    }

    private fun login(){
        val email = binding.loginEmailEt.text.toString()
        val pass = binding.loginPasswordEt.text.toString()
        when {
            email.isEmpty() -> {
                binding.loginEmailEt.error = "برجاء كتابه البريد الاكترونى"
                binding.loginEmailEt.requestFocus()
            }
            pass.isEmpty() -> {
                binding.loginPasswordEt.error = "برجاء كتابه الباسورد"
                binding.loginPasswordEt.requestFocus()
            }
            else -> {
                viewModel.login(Login(email, pass))
            }
        }
    }

}