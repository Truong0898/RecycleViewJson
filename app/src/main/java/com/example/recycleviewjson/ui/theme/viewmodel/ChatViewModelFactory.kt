package com.example.recycleviewjson.ui.theme.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.recycleviewjson.ui.theme.data.repository.ChatRepository

class ChatViewModelFactory(private val chatRepository: ChatRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ChatViewModel::class.java)) {
            return ChatViewModel(chatRepository) as T
        }
        throw IllegalArgumentException("Unknown View model class")
    }
}