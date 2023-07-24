package com.example.recycleviewjson.ui.theme.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.recycleviewjson.R
import com.example.recycleviewjson.ui.theme.data.model.Message

class ChatAdapter(var lsMessage: List<Message>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    val SENT_MSG = 0
    val RECIVED_MSG = 1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        if (viewType == 0) {
            return SendViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_recycleview_layout_me, parent, false)
            )
        } else {
            return ReceiViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_recycleview_layout_u, parent, false)
            )
        }
    }

    override fun getItemCount(): Int {
        return lsMessage.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var msg = lsMessage.get(position)

        if (holder.itemViewType == SENT_MSG) {
            SendViewHolder(holder.itemView).bind(msg)
        } else {
            ReceiViewHolder(holder.itemView).bind(msg)
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