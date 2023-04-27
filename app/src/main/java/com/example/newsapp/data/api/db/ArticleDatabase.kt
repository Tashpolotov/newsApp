package com.example.newsapp.data.api.db

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase


abstract class ArticleDatabase: RoomDatabase() {

    companion object{
        private var instance: ArticleDatabase? = null
        private val LOCK = Any()

        open fun invoke(context: Context) = instance?: synchronized(LOCK) {
            instance?: createDatabase(context).also { instance = it}
        }

        private fun createDatabase(context: Context): ArticleDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                ArticleDatabase::class.java,
                "article_database"
            ).build()
        }
    }
}