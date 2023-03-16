package com.cengcelil.chatbotview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cengcelil.chatbotview.databinding.LayoutChatbotviewOptionBinding

class OptionLayoutViewHolder(val binding: LayoutChatbotviewOptionBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(optionItem: OptionItem, selectedItemCallback: (item: LeftItem) -> Unit) {
        binding.root.adapter = OptionAdapter(optionItem,selectedItemCallback)     }

    companion object {
        private fun getHolder(parent: ViewGroup) = LayoutChatbotviewOptionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        fun getViewHolder(parent: ViewGroup) = OptionLayoutViewHolder(getHolder(parent))
    }
}