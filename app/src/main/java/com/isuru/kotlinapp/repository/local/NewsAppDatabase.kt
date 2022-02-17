package com.isuru.kotlinapp.repository.local

import android.content.Context
import androidx.room.*
import com.isuru.kotlinapp.repository.model.Article

@Database(entities = [Article::class], version = 4, exportSchema = true)
@TypeConverters(Converters::class)
abstract class NewsAppDatabase : RoomDatabase() {

    abstract fun newsApiDao(): NewsAppDao

    companion object {
        private var INSTANCE: NewsAppDatabase? = null

        @Synchronized
        fun newsAppDatabase(context: Context): NewsAppDatabase{
            if (INSTANCE == null){
                INSTANCE = Room.databaseBuilder(context.applicationContext,
                NewsAppDatabase::class.java,
                "db_news_app.db")
                    .fallbackToDestructiveMigration()
                    .build()
            }

            return INSTANCE!!
        }
    }


}