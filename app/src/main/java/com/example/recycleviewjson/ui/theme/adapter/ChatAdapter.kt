package com.example.recycleviewjson.ui.theme.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.recycleviewjson.R
import com.example.recycleviewjson.databinding.ItemRecycleviewLayoutMeBinding
import com.example.recycleviewjson.databinding.ItemRecycleviewLayoutUBinding
import com.example.recycleviewjson.ui.theme.data.model.Message

class ChatAdapter(var lsMessage: List<Message>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    val SENT_MSG = 0
    val RECIVED_MSG = 1
    private lateinit var binding: ItemRecycleviewLayoutMeBinding
    private lateinit var bindingU: ItemRecycleviewLayoutUBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        if (viewType == 0) {
            return SendViewHolder(
                binding = ItemRecycleviewLayoutMeBinding.inflate(LayoutInflater.from(parent.context),parent,false))
        } else {
            return ReceiViewHolder(
               bindingU = ItemRecycleviewLayoutUBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            )
        }
    }

    override fun getItemCount(): Int {
        return lsMessage.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var msg = lsMessage.get(position)

        if (holder.itemViewType == SENT_MSG) {
            SendViewHolder(binding).bind(msg)
        } else {
            ReceiViewHolder(bindingU).bind(msg)
        }
    }

    override fun getItemViewType(position: Int): Int {
        val msg = lsMessage.get(position)
        if (msg.status == SENT_MSG) {
            return SENT_MSG
        }
        return RECIVED_MSG
    }
}