package com.cengcelil.chatbotview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private val chatBotView: ChatBotView by lazy { findViewById(R.id.chatbotview) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.Main).launch {
            chatBotView.addToBotLeft(LeftItem("Selam1"))
            chatBotView.addToBotRight(RightItem("Selam2"))
            chatBotView.setOnClickListener {
                CoroutineScope(Dispatchers.Main).launch {
                    chatBotView.addToBotRight(RightItem(it.message))
                    when (it.message) {
                        "B" -> chatBotView.addToOptions(OptionItem(listOf(LeftItem("c"), LeftItem("d"))))
                        "A" -> chatBotView.addToOptions(OptionItem(listOf(LeftItem("e"), LeftItem("f"))))
                        "c" -> chatBotView.addToOptions(OptionItem(listOf(LeftItem("A"), LeftItem("B"))))
                        "d" -> chatBotView.addToOptions(OptionItem(listOf(LeftItem("c"), LeftItem("d"))))
                        "e" -> chatBotView.addToOptions(OptionItem(listOf(LeftItem("A"), LeftItem("B"))))
                        "f" -> chatBotView.addToOptions(OptionItem(listOf(LeftItem("c"), LeftItem("d"))))
                    }

                }
            }
            chatBotView.addToOptions(
                OptionItem(listOf(LeftItem("A"), LeftItem("B")))
            )
        }
    }
}