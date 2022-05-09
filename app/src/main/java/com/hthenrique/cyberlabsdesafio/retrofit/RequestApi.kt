package com.hthenrique.cyberlabsdesafio.retrofit

import android.content.Context
import com.hthenrique.cyberlabsdesafio.model.Author
import com.hthenrique.cyberlabsdesafio.model.AuthorListResponse
import com.hthenrique.cyberlabsdesafio.util.Constants.Companion.SUCCESS_RESPONSE
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RequestApi(private val context: Context?) : ServiceApi {
    private val retrofitInstance: RetrofitInstance = RetrofitInstance()
    private val retrofitEndPoint = retrofitInstance.getClient().create(RetrofitEndPoint::class.java)

    override fun getAuthorsList(callback: ServiceApi.ServiceApiCallback<AuthorListResponse>) {
        val callAuthors = retrofitEndPoint.getAuthorsList()

        callAuthors.enqueue(object: Callback<AuthorListResponse> {
            override fun onResponse(call: Call<AuthorListResponse>, response: Response<AuthorListResponse>) {
                if (response.code() == SUCCESS_RESPONSE){
                    val authorList: List<Author> = response.body()!!.authorsApi
                    callback.onLoaded(authorList)
                }
            }
            override fun onFailure(call: Call<AuthorListResponse>, t: Throwable) {
                callback.onFailure("Fail load data")
            }
        })

    }
}

