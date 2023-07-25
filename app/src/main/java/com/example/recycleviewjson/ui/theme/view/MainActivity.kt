package com.example.recycleviewjson.ui.theme.view

import android.app.appsearch.GlobalSearchSession
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleviewjson.R
import com.example.recycleviewjson.databinding.ActivityMainBinding
import com.example.recycleviewjson.ui.theme.adapter.ChatAdapter
import com.example.recycleviewjson.ui.theme.data.repository.ChatRepository
import com.example.recycleviewjson.ui.theme.viewmodel.ChatViewModel
import com.example.recycleviewjson.ui.theme.viewmodel.ChatViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class MainActivity : ComponentActivity() {

    private lateinit var chatViewModel: ChatViewModel

    private lateinit var chatAdapter: ChatAdapter

    private lateinit var rcvChat: RecyclerView

    private lateinit var btnSend: Button

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        btnSend = binding.btnSend
        rcvChat = binding.rcvChat

        rcvChat.layoutManager = LinearLayoutManager(this)
        val chatViewModelFactory = ChatViewModelFactory(ChatRepository())
        chatViewModel = ViewModelProvider(this, chatViewModelFactory).get(ChatViewModel::class.java)
        chatViewModel.getMessageFromJson(this,"msg_chat.json")?.observe(this, Observer {
            Log.i("data json", it.get(0).message)
            chatAdapter = ChatAdapter(it)
            rcvChat.adapter = chatAdapter
        })

        btnSend.setOnClickListener {

        }

    }

}


