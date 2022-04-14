package sk.sandeep.newsappcompose.mapper

import sk.sandeep.newsappcompose.data.remote.dto.Article
import sk.sandeep.newsappcompose.domain.model.NewsItem


fun List<Article>.toNewsItem(): List<NewsItem> {
    return map {
        NewsItem(
            author = it.author ?: "Not Available",
            content = it.content ?: "Not Available",
            description = it.description ?: "Not Available",
            publishedAt = it.publishedAt ?: "Not Available",
            title = it.title ?: "Not Available",
            urlToImage = it.urlToImage ?: "Not Available"
        )
    }
}