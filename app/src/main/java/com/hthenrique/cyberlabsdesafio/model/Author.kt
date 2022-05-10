package com.hthenrique.cyberlabsdesafio.model

import com.google.gson.annotations.SerializedName

//@Entity(tableName = "authors")
data class Author(

    @SerializedName("author")
    var author: String? = null,

    @SerializedName("url")
    var url: String? = null,

    @SerializedName("timestamp")
    var timestamp: Any? = null
){
    override fun toString(): String {
        return "Author(author=$author, url=$url, timestamp=$timestamp)"
    }
}

