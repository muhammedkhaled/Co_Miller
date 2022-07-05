package com.example.comiller.ui.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.comiller.R
import com.example.comiller.databinding.FragmentCreatorsBinding
import com.example.comiller.setOnClickListener


class CreatorsFragment : Fragment(R.layout.fragment_creators) {

    private lateinit var binding: FragmentCreatorsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCreatorsBinding.bind(view)

        binding.muKhaledConst.setOnClickListener(1000L){
            val url = "https://www.linkedin.com/in/muhammad-khaled/"
            val intent = Intent(Intent.ACTION_VIEW);
            intent.data = Uri.parse(url)
            startActivity(intent)
        }
    }

}