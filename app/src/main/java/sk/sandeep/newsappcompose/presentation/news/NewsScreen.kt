package sk.sandeep.newsappcompose.presentation.news

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import sk.sandeep.newsappcompose.domain.model.NewsItem


@Composable
fun NewsScreen(viewModel: NewsViewModel = hiltViewModel()) {

    val newsData = viewModel.news.value

    if (newsData.isLoading) {
        Box(modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }

    if (newsData.error.isNotBlank()) {
        Box(modifier = Modifier.fillMaxSize()) {
            Text(text = newsData.error, modifier = Modifier.align(Alignment.Center))
        }
    }

    newsData.data?.let {
        Box(modifier = Modifier.fillMaxSize()) {
            LazyColumn {
                items(it) {
                    NewsItemScreen(it)
                }
            }
        }
    }
}

@Composable
fun NewsItemScreen(
    item: NewsItem,
    modifier: Modifier = Modifier
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        elevation = 5.dp,
        shape = RectangleShape
    ) {
        Column(modifier = modifier.padding(5.dp)) {
            Text(text = item.title, style = TextStyle(Color.Magenta, fontWeight = FontWeight.Bold))
            Spacer(modifier = Modifier.height(5.dp))
            Image(
                painter = rememberImagePainter(data = item.urlToImage),
                contentDescription = "item image",
                modifier = Modifier
                    .height(300.dp)
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(3.dp))
            Text(
                text = item.author,
                style = TextStyle(fontStyle = FontStyle.Italic),
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.height(3.dp))
            Text(
                text = item.description,
                style = TextStyle(fontStyle = FontStyle.Italic),
                fontWeight = FontWeight.Normal,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}
