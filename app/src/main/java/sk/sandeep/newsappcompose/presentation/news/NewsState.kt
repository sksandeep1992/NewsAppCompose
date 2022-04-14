package sk.sandeep.newsappcompose.presentation.news

import sk.sandeep.newsappcompose.domain.model.NewsItem

data class NewsState(
    val isLoading: Boolean = false,
    val data: List<NewsItem>? = null,
    val error: String = ""
)