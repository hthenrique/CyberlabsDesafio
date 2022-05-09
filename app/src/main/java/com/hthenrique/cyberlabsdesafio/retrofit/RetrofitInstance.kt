package com.hthenrique.cyberlabsdesafio.retrofit

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.hthenrique.cyberlabsdesafio.util.Constants.Companion.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {

    private val gson: Gson = GsonBuilder().create()
    private var retrofit: Retrofit? = null


    fun getClient(): Retrofit{
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        val client = OkHttpClient.Builder()
                        .addInterceptor(logging)
                        .build()

        retrofit = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .client(client)
                        .build()

        return this.retrofit!!
    }
}