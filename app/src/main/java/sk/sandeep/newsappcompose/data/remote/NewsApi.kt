package sk.sandeep.newsappcompose.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import sk.sandeep.newsappcompose.common_or_util.Constants.API_KEY
import sk.sandeep.newsappcompose.data.remote.dto.NewsDto

interface NewsApi {

    @GET("top-headlines")
    suspend fun getTopHeadlines(
        @Query("country") country: String = "in",
        @Query("apiKey") apiKey: String = API_KEY
    ): Response<NewsDto>
}