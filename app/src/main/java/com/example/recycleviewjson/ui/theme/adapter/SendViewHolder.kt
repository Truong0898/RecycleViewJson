package com.example.recycleviewjson.ui.theme.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleviewjson.R
import com.example.recycleviewjson.ui.theme.data.model.Message

class SendViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val txtDateMe:TextView
    val txtMessageMe: TextView
    val txTimeMe: TextView

    init{
        txtDateMe = itemView.findViewById(R.id.txtDateMe)
        txtMessageMe = itemView.findViewById(R.id.txtMessageMe)
        txTimeMe = itemView.findViewById(R.id.txTimeMe)

    }

    fun bind(message: Message) {
        txtMessageMe.text = message.message
        txTimeMe.text = message.timeLine
    }
}