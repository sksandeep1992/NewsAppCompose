package sk.sandeep.newsappcompose.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NewsItem(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val title: String,
    val urlToImage: String,
    @PrimaryKey(autoGenerate = true) val id: Int? = null
)
