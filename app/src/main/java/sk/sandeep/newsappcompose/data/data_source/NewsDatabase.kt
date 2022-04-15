package sk.sandeep.newsappcompose.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import sk.sandeep.newsappcompose.domain.model.NewsItem

@Database(
    entities = [NewsItem::class],
    version = 1,
    exportSchema = false
)
abstract class NewsDatabase : RoomDatabase() {
    abstract val newsDao: NewsDao

    companion object {
        const val DATABASE_NAME = "notes_db"
    }
}