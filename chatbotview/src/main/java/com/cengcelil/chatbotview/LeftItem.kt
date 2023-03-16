package com.cengcelil.chatbotview

data class LeftItem(val message: String):BaseItem {
    override fun getPosition(): Position =Position.LEFT
}