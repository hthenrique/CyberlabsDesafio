package com.hthenrique.cyberlabsdesafio.model

import com.google.gson.annotations.SerializedName

//@Entity(tableName = "authors")
data class Author(

    @SerializedName("author")
    var author: String? = null,

    @SerializedName("url")
    val url: String? = null,

    @SerializedName("timestamp")
    val timestamp: Any? = null
){
    override fun toString(): String {
        return "Author(author=$author, url=$url, timestamp=$timestamp)"
    }
}

