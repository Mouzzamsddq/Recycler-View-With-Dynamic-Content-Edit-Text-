package com.example.recyclerviewwithdynamiccontent

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewwithdynamiccontent.databinding.ViewHolderEditTextBinding

class DynamicContentAdapter(
    private val context: Context
) : RecyclerView.Adapter<DynamicContentAdapter.EditTextViewHolder>() {


    private var dynamicDataSet = emptyList<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EditTextViewHolder {
        val binding = ViewHolderEditTextBinding.inflate(LayoutInflater.from(context), parent, false)
        return EditTextViewHolder(binding)
    }

    override fun getItemCount() = dynamicDataSet.size

    override fun onBindViewHolder(holder: EditTextViewHolder, position: Int) {
        dynamicDataSet.getOrNull(position)?.let {
            holder.bind(it)
        }
    }

    override fun getItemViewType(position: Int) = position

    override fun getItemId(position: Int) = position.toLong()


    class EditTextViewHolder(
        private val binding: ViewHolderEditTextBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(text: String) {
            binding.labelTv.text = text
        }
    }

    fun setData(data: List<String>) {
        this.dynamicDataSet = data
        notifyDataSetChanged()
    }

}