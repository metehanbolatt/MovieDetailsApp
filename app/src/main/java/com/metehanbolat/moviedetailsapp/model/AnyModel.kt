package com.metehanbolat.moviedetailsapp.model

import com.google.gson.annotations.SerializedName

data class AnyModel(
    // Eğer gelecek isimle constructor'da tanımlanan isim aynı ise serialized etmeye gerek yok.
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: String,
    @SerializedName("url")
    val url: String
)