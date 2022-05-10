package com.hthenrique.cyberlabsdesafio.model

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test


class AuthorTest{

    private lateinit var author: Author

    @Before
    fun setup(){
        author = mockAuthor()
    }

    @Test
    fun authorTest(){
        val authorTest: Author = author
        assertEquals(author.author, authorTest.author)
        assertEquals(author.url, authorTest.url)
        assertEquals(author.timestamp, authorTest.timestamp)
    }

    @Test
    fun authorToStringTest(){
        val authorTest: Author = this.author
        val expected = "Author(author=Teste, url=teste.com/teste, timestamp=1987928731)"
        assertEquals(expected, authorTest.toString())
    }

    private fun mockAuthor(): Author {
        val author = Author()
        author.author = "Teste"
        author.url = "teste.com/teste"
        author.timestamp = 1987928731

        return author
    }

}