package com.volcanolabs.multiplesapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MultiplesListAdapter : RecyclerView.Adapter<MultiplesListAdapter.MultiplesViewHolder>() {
    private var multiplesList: List<String>? = null

    fun setData(list: List<String>) {
        multiplesList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MultiplesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.multiple_number_item, parent, false)
        return MultiplesViewHolder(view)
    }

    override fun onBindViewHolder(holder: MultiplesViewHolder, position: Int) {
        val value = multiplesList?.get(position) ?: ""
        holder.bind(value)
    }

    override fun getItemCount(): Int {
        return multiplesList?.size ?: 0
    }

    class MultiplesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var textView: TextView = itemView.findViewById(R.id.tv_value)

        fun bind(value: String) {
            textView.text = value
        }
    }
}