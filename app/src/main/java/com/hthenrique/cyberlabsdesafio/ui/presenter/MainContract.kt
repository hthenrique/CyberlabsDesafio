package com.hthenrique.cyberlabsdesafio.ui.presenter

import com.hthenrique.cyberlabsdesafio.model.Author

interface MainContract {
    interface View{
        fun showAuthors(authorList: List<Author>)
        fun showFailure(errorMessage: String?)
    }

    interface AuthorActionListener{
        fun loadAuthors()
        fun loadAuthorsOnDatabase()
    }
}