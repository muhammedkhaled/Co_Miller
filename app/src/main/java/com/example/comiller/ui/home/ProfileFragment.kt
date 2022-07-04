package com.example.comiller.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import com.example.comiller.R
import com.example.comiller.data.cash.UserPreferences
import com.example.comiller.databinding.FragmentProfileBinding
import com.example.comiller.viewModels.ProfileViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private lateinit var binding: FragmentProfileBinding
    private lateinit var viewModel: ProfileViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProfileBinding.bind(view)

        val userPreferences = UserPreferences(requireContext())
        runBlocking {
            val name = userPreferences.userName.first()
            binding.nameValueTv.text = name

            val email = userPreferences.userEmail.first()
            binding.emailValueTv.text = email

            val phone = userPreferences.userPhone.first()
            binding.phoneValueTv.text = phone
        }
    }
}