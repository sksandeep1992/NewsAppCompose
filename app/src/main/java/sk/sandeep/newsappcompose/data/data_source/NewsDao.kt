package sk.sandeep.newsappcompose.data.data_source

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import sk.sandeep.newsappcompose.domain.model.NewsItem

@Dao
interface NewsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(newsItem: NewsItem)

    @Query("SELECT * FROM newsItem")
    fun getAllNews(): Flow<List<NewsItem>>

    @Delete
    suspend fun deleteNewsItem(newsItem: NewsItem)
}