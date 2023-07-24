package com.example.recycleviewjson.ui.theme.data.repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.recycleviewjson.ui.theme.data.model.Message
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException

class ChatRepository {
    private fun getJsonDataFromAsset(context: Context, filename: String): String? {
        val  jsonString: String
        try {
             jsonString = context.assets.open(filename).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString

    }
    fun getListMessage(context: Context, filename: String) : MutableLiveData<List<Message>>? {
        var mutableMessage = MutableLiveData<List<Message>>()
        var lsMessage = ArrayList<Message>()
        var jsonData = getJsonDataFromAsset(context,filename)?: null

        val jsonObject = JSONObject(jsonData)
        val jsonArray = jsonObject.getJSONArray("data")

        for (i in 0 until jsonArray.length()) {
            val messageJsonObject = jsonArray[i]as JSONObject
            var message: Message = Message()
            message.name = messageJsonObject.getString("name")
            message.message = messageJsonObject.getString("message")
            message.timeLine = messageJsonObject.getString("timeLine")
            message.status = 1

            lsMessage.add(message)
        }
        mutableMessage.postValue(lsMessage)
        return mutableMessage

    }

}