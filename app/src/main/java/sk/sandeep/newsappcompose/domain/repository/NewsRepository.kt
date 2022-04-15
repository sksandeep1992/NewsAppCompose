package sk.sandeep.newsappcompose.domain.repository

import kotlinx.coroutines.flow.Flow
import sk.sandeep.newsappcompose.domain.model.NewsItem

interface NewsRepository {

    suspend fun getNewsItems(): List<NewsItem>

    fun getNewsFromDb(): Flow<List<NewsItem>>

    suspend fun insertNewsItem(newsItem: NewsItem)

    suspend fun deleteNewsItem(newsItem: NewsItem)
}