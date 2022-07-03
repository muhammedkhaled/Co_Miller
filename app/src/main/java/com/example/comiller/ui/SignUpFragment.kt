package com.example.comiller.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.example.comiller.*
import com.example.comiller.data.cash.UserPreferences
import com.example.comiller.data.network.RemoteDataSource
import com.example.comiller.data.network.interfaces.AuthApi
import com.example.comiller.data.network.response.Register
import com.example.comiller.databinding.FragmentLoginBinding
import com.example.comiller.databinding.FragmentSignUpBinding
import com.example.comiller.repository.AuthRepository
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
                    binding.root.snackbar("تم انشاء حساب جديد بنجاح")
                    requireActivity().startNewActivity(HomeActivity::class.java)
                    // TODO: cash response after parsing
                }
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
                binding.regisVolNameEt.error = "برجاء كتابه الآسم"
                binding.regisVolNameEt.requestFocus()
            }
            email.isEmpty() -> {
                binding.regisEmailEt.error = "برجاء كتابه البريد الاكترونى"
                binding.regisEmailEt.requestFocus()
            }
            phone.isEmpty() -> {
                binding.regisVolPhoneEt.error = "برجاء كتابه رقم الهاتف"
                binding.regisVolPhoneEt.requestFocus()
            }
            pass.isEmpty() -> {
                binding.regisVolPassEt.error = "برجاء كتابه الباسورد"
                binding.regisVolPassEt.requestFocus()
            }
            else -> {
                viewModel.register(Register(name, email, phone, pass))
            }
        }
    }

}