package com.cengcelil.chatbotview

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class OptionAdapter(val optionItem: OptionItem, var selectedItemCallback: (leftItem: LeftItem) -> Unit) : RecyclerView.Adapter<OptionItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OptionItemViewHolder =
        OptionItemViewHolder.getViewHolder(parent)

    override fun getItemCount() = optionItem.options.size

    override fun onBindViewHolder(holder: OptionItemViewHolder, position: Int) {
        val item = optionItem.options[position]
        if (item == optionItem.selectedRightItem)
            holder.updateSelected()
        holder.bind(item) {
            if (optionItem.selectedRightItem==null) {
                optionItem.selectedRightItem = it
                selectedItemCallback(it)
                notifyItemChanged(optionItem.options.indexOf(item))
            }
        }
    }


}