package com.cengcelil.chatbotview

data class OptionItem(val options: List<LeftItem>, var selectedRightItem: LeftItem?=null) : BaseItem {
    override fun getPosition(): Position =Position.OPTION
}