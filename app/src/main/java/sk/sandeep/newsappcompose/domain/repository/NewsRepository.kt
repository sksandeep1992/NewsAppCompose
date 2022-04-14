package sk.sandeep.newsappcompose.domain.repository

import sk.sandeep.newsappcompose.domain.model.NewsItem

interface NewsRepository {

    suspend fun getNewsItems(): List<NewsItem>
}