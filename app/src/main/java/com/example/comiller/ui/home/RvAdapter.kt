package com.example.comiller.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.comiller.R
import com.example.comiller.data.network.response.Data

class RvAdapter() : ListAdapter<Data, ViewHolder>(JobOrderDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder.from(parent)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
         holder.bind(item)
    }

    private var list = listOf<Data>()

    fun setData(list: List<Data>) {
        this.list = list
        submitList(list)
    }
}

class ViewHolder (val itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(item: Data) {
        itemView.findViewById<TextView>(R.id.itemTitle_tv).text = item.title
        itemView.findViewById<TextView>(R.id.itemValue_tv).text = item.value
    }
    companion object {
        fun from(parent: ViewGroup): ViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = layoutInflater.inflate(R.layout.item, parent, false)
            return ViewHolder(binding)
        }
    }
}

class JobOrderDiffCallback : DiffUtil.ItemCallback<Data>() {
    override fun areItemsTheSame(
        oldItem: Data,
        newItem: Data
    ): Boolean {
        return oldItem.title == newItem.value
    }

    override fun areContentsTheSame(
        oldItem: Data,
        newItem: Data
    ): Boolean {
        return oldItem == newItem
    }
}
