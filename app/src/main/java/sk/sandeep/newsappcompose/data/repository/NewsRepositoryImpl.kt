package sk.sandeep.newsappcompose.data.repository

import sk.sandeep.newsappcompose.common_or_util.SafeApiRequest
import sk.sandeep.newsappcompose.data.remote.NewsApi
import sk.sandeep.newsappcompose.domain.model.NewsItem
import sk.sandeep.newsappcompose.domain.repository.NewsRepository
import sk.sandeep.newsappcompose.mapper.toNewsItem
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val api: NewsApi
) : NewsRepository,SafeApiRequest() {
     override suspend fun getNewsItems(): List<NewsItem> {
       val  response =safeApiRequest {
           api.getTopHeadlines()
       }
        return response.articles?.toNewsItem()!!
    }
}