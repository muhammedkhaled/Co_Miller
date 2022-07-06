package com.example.comiller.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.*
import androidx.compose.foundation.layout.Column
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.core.content.ContentProviderCompat
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.comiller.*
import com.example.comiller.data.cash.UserPreferences
import com.example.comiller.databinding.FragmentProfileBinding
import com.example.comiller.ui.intro.OnBoardingActivity
import com.example.comiller.viewModels.ProfileViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import net.aqua_waterfliter.jo.confirmation.data.network.ResultWrapper

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private lateinit var binding: FragmentProfileBinding
    private val viewModel: ProfileViewModel by viewModels()

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

        binding.removeAccBtn.setOnClickListener(1000L){
            dialog()
        }
    }

    private fun dialog() {
        val alertDialog = androidx.appcompat.app.AlertDialog.Builder(requireContext()).create()
        val factory = LayoutInflater.from(requireContext())
        val view: View = factory.inflate(R.layout.dialog, null)
        val okBtn = view.findViewById<Button>(R.id.ok_btn)
        val cancelBtn = view.findViewById<Button>(R.id.cancel_btn)
        val image = view.findViewById<ImageView>(R.id.imageView)
        val passEt = view.findViewById<EditText>(R.id.deleteAccPassword_et)
        val progressBar = view.findViewById<ProgressBar>(R.id.dialogLoadingProgress)

        image.setImageResource(R.drawable.ic_check)
        ResourcesCompat.getColor(resources, R.color.red, resources.newTheme())

        okBtn.setOnClickListener(2000L) {
            val pass = passEt.text.trim().toString()
            if (pass.isNotEmpty()){
//                viewModel.removeAcc(pass)

                Toast.makeText(requireContext(), "account deleted successfully", Toast.LENGTH_SHORT).show()
                alertDialog.dismiss()
                requireActivity().startNewActivity(OnBoardingActivity::class.java)
            } else {
                passEt.error = "please write your password"
                passEt.requestFocus()
            }
        }

        viewModel.removeAcc.observe(viewLifecycleOwner){
            progressBar.visible(it is ResultWrapper.Loading)
            progressBar.enable(it !is ResultWrapper.Loading)

            when (it) {
                is ResultWrapper.Success -> {
                    Toast.makeText(requireContext(), "account deleted successfully", Toast.LENGTH_SHORT).show()
                    alertDialog.dismiss()
                    requireActivity().startNewActivity(OnBoardingActivity::class.java)
                }
                is ResultWrapper.GenericError -> handleApiError(
                    it,
                    root = view.rootView
                )
            }
        }

        cancelBtn.setOnClickListener {
            alertDialog.dismiss()
        }

        alertDialog.window?.setBackgroundDrawableResource(android.R.color.transparent);
        alertDialog.setView(view)
        alertDialog.setCancelable(false)
        alertDialog.show()
    }
}

