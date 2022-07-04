package com.example.comiller.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.comiller.R
import com.example.comiller.databinding.FragmentResultBinding
import com.example.comiller.viewModels.HomeViewModel
import com.example.comiller.viewModels.ResultViewModel

private const val ARG_PARAM1 = "param1"

class ResultFragment : Fragment(R.layout.fragment_result) {

    private lateinit var binding: FragmentResultBinding
    private lateinit var viewModel: HomeViewModel

    private val resultViewModel: ResultViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentResultBinding.bind(view)


        val adapter = RvAdapter()

//        val obj = Json.decodeFromString<List<Data>>(jsonList!!)
//        Log.d(ResultFragment.TAG, "program list: ${obj[15]}")

        resultViewModel.resultData.observe(viewLifecycleOwner, Observer{
            adapter.setData(it.data)
//            Toast.makeText(requireContext(), "${it.data[15]}", Toast.LENGTH_SHORT).show()
        })

        val gridLayoutManager = StaggeredGridLayoutManager(1, RecyclerView.VERTICAL)
        binding.resultRv.layoutManager = gridLayoutManager
        binding.resultRv.adapter = adapter


    }

    companion object {
        const val TAG = "CreateNewAccBtmFragment"
        var jsonList: String? = null
        @JvmStatic
        fun newInstance(param1: String) =
            ResultFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }
}