package ru.example.mvpvm_rx_kotlin.info

import com.google.gson.annotations.SerializedName

data class InfoModel(@SerializedName("image") var image: Int,
                     @SerializedName("name") var name: String,
                     @SerializedName("lastname") var lastname: String)