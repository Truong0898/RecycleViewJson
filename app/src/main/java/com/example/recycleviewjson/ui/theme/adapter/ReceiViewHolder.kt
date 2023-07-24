package com.example.recycleviewjson.ui.theme.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleviewjson.R
import com.example.recycleviewjson.ui.theme.data.model.Message

class ReceiViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val txtDateYou: TextView
    val txtNameYou: TextView
    val txtMessageYou: TextView
    val txtTimeYou: TextView

    init {
        txtDateYou = itemView.findViewById<TextView>(R.id.txtDateYou)
        txtNameYou = itemView.findViewById<TextView>(R.id.txtNameYou)
        txtMessageYou = itemView.findViewById<TextView>(R.id.txtMessageYou)
        txtTimeYou = itemView.findViewById(R.id.txtTimeYou)

    }

    fun bind( message: Message) {
        txtNameYou.text = message.name
        txtMessageYou.text = message.message
        txtTimeYou.text = message.timeLine

    }
}