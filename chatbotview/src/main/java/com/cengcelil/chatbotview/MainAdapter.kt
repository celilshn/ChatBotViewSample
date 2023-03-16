package com.cengcelil.chatbotview

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainAdapter(val clickCallback: ((item: LeftItem) -> Unit)? = null) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val TAG = "XX : MainAdapter"
    override fun getItemViewType(position: Int) = list[position].getPosition().pos
    private val list = ArrayList<BaseItem>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = when (viewType) {
        Position.LEFT.pos -> LeftItemViewHolder.getViewHolder(parent)
        Position.RIGHT.pos -> RightItemViewHolder.getViewHolder(parent)
        else -> OptionLayoutViewHolder.getViewHolder(parent)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        println(TAG + "onBindViewHolder $position ${holder.isRecyclable}")
        val item = list[position]
        val selectedItemCallback: (item: LeftItem) -> Unit = {
            holder.setIsRecyclable(false)
            clickCallback?.let { it1 -> it1(it) }
        }
        when (holder.itemViewType) {
            Position.LEFT.pos -> (holder as LeftItemViewHolder).bind(item as LeftItem)
            Position.OPTION.pos -> (holder as OptionLayoutViewHolder).bind(item as OptionItem, selectedItemCallback)
            Position.RIGHT.pos -> (holder as RightItemViewHolder).bind(item as RightItem)
        }
    }

    suspend fun addItemLeft(leftItem: LeftItem): Int = withContext(Dispatchers.Main) {
        list.add(leftItem)
        println(TAG + "addItemLeft ${leftItem.message}")
        notifyItemInserted(list.lastIndex)
        list.lastIndex
    }

    suspend fun addItemRight(rightItem: RightItem): Int {
        list.add(rightItem)
        notifyItemInserted(list.lastIndex)
        return list.lastIndex
    }

    suspend fun addItemOptions(optionItem: OptionItem): Int {
        list.add(optionItem)
        notifyItemInserted(list.lastIndex)
        return list.lastIndex
    }

    suspend fun addTypingEffect(): Int = addItemLeft(LeftItem("..."))

    suspend fun removeTypingEffect(): Int {
        list.removeLast()
        println(TAG + "removeTypingEffect ")
        notifyItemRemoved(list.lastIndex + 1)
        return list.lastIndex
    }


}