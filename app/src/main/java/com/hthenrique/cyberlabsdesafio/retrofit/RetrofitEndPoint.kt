package com.hthenrique.cyberlabsdesafio.retrofit

import com.hthenrique.cyberlabsdesafio.model.AuthorListResponse
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitEndPoint {

    @GET("images.json")
    fun getAuthorsList(): Call<AuthorListResponse>
}