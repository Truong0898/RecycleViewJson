package com.example.recycleviewjson.ui.theme.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleviewjson.R
import com.example.recycleviewjson.databinding.ItemRecycleviewLayoutMeBinding
import com.example.recycleviewjson.databinding.ItemRecycleviewLayoutUBinding
import com.example.recycleviewjson.ui.theme.data.model.Message
import java.sql.Date
import java.text.SimpleDateFormat

class ReceiViewHolder(val bindingU: ItemRecycleviewLayoutUBinding) : RecyclerView.ViewHolder(bindingU.root) {


    fun bind(message: Message) {
        bindingU.message = message
    }

}