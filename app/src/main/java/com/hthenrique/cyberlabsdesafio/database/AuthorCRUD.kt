package com.hthenrique.cyberlabsdesafio.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.hthenrique.cyberlabsdesafio.model.Author

@Dao
interface AuthorCRUD {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAuthors(author: Author)

    //@Query("SELECT * FROM authors")
    fun getAllAuthors(): List<Author>

    //@Query("DELETE FROM authors")
    suspend fun deleteAllAuthors()
}