package com.cengcelil.chatbotview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cengcelil.chatbotview.databinding.ItemChatbotviewLeftBinding

class LeftItemViewHolder(val binding: ItemChatbotviewLeftBinding) : RecyclerView.ViewHolder(binding.root) {
    private val TAG = "XX : LeftItemViewHolder"

    fun bind(rightItem: LeftItem) {
        println(TAG + "onBindViewHolder $position $isRecyclable")
        binding.txt.text = rightItem.message
    }

    companion object {
        private fun getHolder(parent: ViewGroup)=ItemChatbotviewLeftBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        fun getViewHolder(parent: ViewGroup)=LeftItemViewHolder(getHolder(parent))
    }

}