package com.hthenrique.cyberlabsdesafio.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hthenrique.cyberlabsdesafio.model.Author
import com.hthenrique.cyberlabsdesafio.util.Constants.Companion.DB_VERSION

@Database(entities = [Author::class], version = DB_VERSION)
abstract class AuthorsDatabase: RoomDatabase() {

    abstract fun getAuthorDao(): AuthorCRUD

    private lateinit var INSTANCE: Database

    companion object {
        @Volatile
        private var databaseInstance: AuthorsDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = databaseInstance?: synchronized(LOCK){
            databaseInstance?: createDatabase(context).also { databaseInstance = it }
        }

        private fun createDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            AuthorsDatabase::class.java,
            "author_database.db"
        ).build()
    }

}
