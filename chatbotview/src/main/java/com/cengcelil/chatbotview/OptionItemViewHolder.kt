package com.cengcelil.chatbotview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.cengcelil.chatbotview.databinding.ItemChatbotviewOptionBinding

class OptionItemViewHolder(val binding: ItemChatbotviewOptionBinding) : RecyclerView.ViewHolder(binding.root) {
    private  val TAG = "XX : OptionItemViewHolder"
    fun bind(leftItem: LeftItem, clickCallback: (leftItem: LeftItem) -> Unit) {
        println(TAG + "onBindViewHolder $position $isRecyclable")
        binding.txt.text = leftItem.message
        binding.card.setOnClickListener { clickCallback(leftItem) }
    }

    fun updateSelected() {
        binding.card.setCardBackgroundColor(AppCompatResources.getColorStateList(binding.card.context, android.R.color.holo_red_dark))
    }

    companion object {
        private fun getHolder(parent: ViewGroup) = ItemChatbotviewOptionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        fun getViewHolder(parent: ViewGroup) = OptionItemViewHolder(getHolder(parent))
        val selectedOptionList = ArrayList<Int>()
    }
}