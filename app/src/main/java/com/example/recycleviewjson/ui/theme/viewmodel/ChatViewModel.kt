package com.example.recycleviewjson.ui.theme.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recycleviewjson.ui.theme.data.model.Message
import com.example.recycleviewjson.ui.theme.data.repository.ChatRepository

class ChatViewModel( private val chatRepository : ChatRepository): ViewModel() {
    fun getMessageFromJson(context: Context,fileName:String) : MutableLiveData<List<Message>>? {
        return chatRepository.getListMessage(context,fileName)
    }
}