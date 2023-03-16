package com.cengcelil.chatbotview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cengcelil.chatbotview.databinding.ItemChatbotviewRightBinding

class RightItemViewHolder(val binding: ItemChatbotviewRightBinding) : RecyclerView.ViewHolder(binding.root) {
    private val TAG = "XX : RightItemViewHolder"
    fun bind(rightItem: RightItem) {
        println(TAG + "onBindViewHolder $position $isRecyclable")

binding.txt.text=rightItem.message
    }

    companion object {
        private fun getHolder(parent: ViewGroup) = ItemChatbotviewRightBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        fun getViewHolder(parent: ViewGroup) = RightItemViewHolder(getHolder(parent))
    }
}