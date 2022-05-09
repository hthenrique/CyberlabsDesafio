package com.hthenrique.cyberlabsdesafio.retrofit

import com.hthenrique.cyberlabsdesafio.model.Author
import com.hthenrique.cyberlabsdesafio.model.AuthorListResponse

interface ServiceApi {
    interface ServiceApiCallback<T>{
        fun onLoaded(author: List<Author>)
        fun onFailure(message: String?)
    }

    fun getAuthorsList(callback: ServiceApiCallback<AuthorListResponse>)
}