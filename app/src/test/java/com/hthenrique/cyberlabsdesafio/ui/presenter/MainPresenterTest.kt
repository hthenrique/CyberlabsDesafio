package com.hthenrique.cyberlabsdesafio.ui.presenter

import android.content.Context
import com.hthenrique.cyberlabsdesafio.model.AuthorListResponse
import com.hthenrique.cyberlabsdesafio.retrofit.RequestApi
import com.hthenrique.cyberlabsdesafio.retrofit.ServiceApi
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations
import retrofit2.Response

internal class MainPresenterTest {

    private lateinit var mainPresenter: MainPresenter
    private lateinit var serviceApi: ServiceApi

    @Mock
    private lateinit var view: MainContract.View

    @Mock
    private lateinit var context: Context

    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)
        context = mock(Context::class.java)
        serviceApi = RequestApi(context)
        mainPresenter = MainPresenter(Mockito.any(), Mockito.any())
    }

    @Test
    fun loadAuthorsTest() {

    }

    fun response(): Response<AuthorListResponse> {
        val authorListResponse = AuthorListResponse()

        return Response.success(200, authorListResponse)
    }
}