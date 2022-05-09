package com.hthenrique.cyberlabsdesafio.ui.presenter

import android.content.Context
import com.hthenrique.cyberlabsdesafio.model.Author
import com.hthenrique.cyberlabsdesafio.model.AuthorListResponse
import com.hthenrique.cyberlabsdesafio.retrofit.RequestApi
import com.hthenrique.cyberlabsdesafio.retrofit.ServiceApi

class MainPresenter(authorView: MainContract.View?, context: Context): MainContract.AuthorActionListener {
    private val serviceApi: ServiceApi
    //private val serviceDatabase: AuthorsDatabase
    private val presenterAuthorView: MainContract.View?

    init {
        serviceApi = RequestApi(context)
        presenterAuthorView = authorView
        //serviceDatabase = context?.let { AuthorsDatabase(it) }!!
    }

    override fun loadAuthors(){
        serviceApi.getAuthorsList(object : ServiceApi.ServiceApiCallback<AuthorListResponse>{
            override fun onLoaded(author: List<Author>) {
                presenterAuthorView?.showAuthors(author)
            }
            override fun onFailure(errorMessage: String?) {
                presenterAuthorView?.showFailure(errorMessage)
            }
        })

    }

    override fun loadAuthorsOnDatabase() {
        //TODO
    }


}