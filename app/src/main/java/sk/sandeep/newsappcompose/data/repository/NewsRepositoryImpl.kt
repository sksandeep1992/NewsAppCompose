package sk.sandeep.newsappcompose.data.repository

import kotlinx.coroutines.flow.Flow
import sk.sandeep.newsappcompose.common_or_util.SafeApiRequest
import sk.sandeep.newsappcompose.data.data_source.NewsDao
import sk.sandeep.newsappcompose.data.remote.NewsApi
import sk.sandeep.newsappcompose.domain.model.NewsItem
import sk.sandeep.newsappcompose.domain.repository.NewsRepository
import sk.sandeep.newsappcompose.mapper.toNewsItem
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val api: NewsApi,
    private val dao:NewsDao
) : NewsRepository,SafeApiRequest() {
     override suspend fun getNewsItems(): List<NewsItem> {
       val  response =safeApiRequest {
           api.getTopHeadlines()
       }
        return response.articles?.toNewsItem()!!
    }

    override fun getNewsFromDb(): Flow<List<NewsItem>> {
        return dao.getAllNews()
    }

    override suspend fun insertNewsItem(newsItem: NewsItem) {
        return dao.insert(newsItem = newsItem)
    }

    override suspend fun deleteNewsItem(newsItem: NewsItem) {
        return dao.deleteNewsItem(newsItem = newsItem)
    }
}