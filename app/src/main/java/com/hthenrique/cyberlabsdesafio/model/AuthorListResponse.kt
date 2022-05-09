package com.hthenrique.cyberlabsdesafio.model

import com.google.gson.annotations.SerializedName


class AuthorListResponse{

    @SerializedName("images")
    var authorsApi: ArrayList<Author> = arrayListOf()
}