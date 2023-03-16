package com.cengcelil.chatbotview

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class ChatBotView @JvmOverloads constructor(context: Context, attrs: AttributeSet?) : RecyclerView(context, attrs) {
    private var clickListener: ((item: LeftItem) -> Unit)? = null
    private var typingEffectMS = 200L
    private val botMainAdapter = MainAdapter() {
        clickListener?.let { it1 -> it1(it) }
    }

    init {
        adapter = botMainAdapter
        layoutManager = LinearLayoutManager(context, VERTICAL, false)
    }

    suspend fun addToBotLeft(item: LeftItem) = withContext(Dispatchers.Main) {
        typingEffect { botMainAdapter.addItemLeft(item) }
    }

    suspend fun addToBotRight(rightItem: RightItem) =
        scrollToPosition(botMainAdapter.addItemRight(rightItem))

    suspend fun addToOptions(optionItem: OptionItem) = typingEffect { botMainAdapter.addItemOptions(optionItem) }
    fun setOnClickListener(unit: ((item: LeftItem) -> Unit)?) {
        clickListener = unit
    }

    private suspend inline fun typingEffect(
        crossinline executable: suspend () -> Int
    ) = withContext(Dispatchers.Main) {
        if (typingEffectMS > 0) {
            scrollToPosition(botMainAdapter.addTypingEffect())
            delay(typingEffectMS)
            botMainAdapter.removeTypingEffect()
        }
        scrollToPosition(executable())
    }


}