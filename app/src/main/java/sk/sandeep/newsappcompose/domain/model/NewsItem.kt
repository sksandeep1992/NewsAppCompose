package sk.sandeep.newsappcompose.domain.model

data class NewsItem(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val title: String,
    val urlToImage: String
)
