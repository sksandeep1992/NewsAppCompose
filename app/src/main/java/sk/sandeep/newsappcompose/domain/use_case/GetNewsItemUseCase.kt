package sk.sandeep.newsappcompose.domain.use_case

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import sk.sandeep.newsappcompose.common_or_util.Resource
import sk.sandeep.newsappcompose.domain.model.NewsItem
import sk.sandeep.newsappcompose.domain.repository.NewsRepository
import javax.inject.Inject

class GetNewsItemUseCase @Inject constructor(
    private val repository: NewsRepository
) {
    operator fun invoke(): Flow<Resource<List<NewsItem>>> = flow {
        emit(Resource.Loading())
        try {

            val newsItem = repository.getNewsItems()
            emit(Resource.Success(newsItem))
        } catch (e: Exception) {
            emit(Resource.Error(e.message!!))
        }
    }
}