package com.cengcelil.chatbotview

data class RightItem(val message: String):BaseItem {
    override fun getPosition(): Position =Position.RIGHT
}