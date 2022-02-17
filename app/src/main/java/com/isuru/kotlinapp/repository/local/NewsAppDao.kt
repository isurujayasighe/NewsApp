package com.isuru.kotlinapp.repository.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.isuru.kotlinapp.repository.model.Article

@Dao
interface NewsAppDao {

   @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun insertArticles(article: Article)

   @Query("SELECT * FROM tbl_articles")
   fun getArticles(): LiveData<List<Article>>
}