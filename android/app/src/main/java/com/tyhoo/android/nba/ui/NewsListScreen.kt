package com.tyhoo.android.nba.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.tyhoo.android.nba.data.NewsData
import com.tyhoo.android.nba.viewmodel.NewsListViewModel

@Composable
fun NewsListScreen(
    modifier: Modifier = Modifier,
    viewModel: NewsListViewModel = hiltViewModel(),
    onNewsClick: (NewsData) -> Unit
) {
    val newsList by viewModel.newsList.observeAsState(emptyList())
    NewsListScreen(modifier, newsList, onNewsClick)
}

@Composable
fun NewsListScreen(
    modifier: Modifier = Modifier,
    newsList: List<NewsData>,
    onNewsClick: (NewsData) -> Unit = {}
) {
    LazyColumn(modifier = modifier) {
        items(items = newsList) { news ->
            NewsItem(news = news) {
                onNewsClick(news)
            }
            HorizontalDivider(
                thickness = 0.5.dp,
                color = Color.Gray,
                modifier = Modifier.padding(start = 8.dp, end = 8.dp)
            )
        }
    }
}

@Composable
fun NewsItem(news: NewsData, onNewsClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, bottom = 8.dp)
            .clickable { onNewsClick() }
    ) {
        val imageUrl = news.thumbnailY.ifEmpty { news.thumbnail }

        // 新闻缩略图
        AsyncImage(
            model = imageUrl,
            contentDescription = news.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(width = 150.dp, height = 200.dp)
                .padding(start = 8.dp)
        )

        Column(
            modifier = Modifier
                .height(200.dp)
                .padding(start = 8.dp, end = 8.dp)
        ) {
            Text(
                text = news.title,
                style = TextStyle(fontSize = 20.sp)
            )

            Spacer(modifier = Modifier.weight(1F))

            Text(
                text = "来源：" + news.source,
                style = TextStyle(fontSize = 14.sp),
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Text(
                text = "时间：" + news.publishTime,
                style = TextStyle(fontSize = 14.sp)
            )
        }
    }
}

@Preview
@Composable
fun PreviewNewsItem() {
    val testNews = NewsData(
        "",
        "2024 NBA季后赛最新对阵图",
        "",
        "",
        "2024-05-17 14:10:36",
        "NBA官网"
    )
    Box(modifier = Modifier.background(color = Color.White)) {
        NewsItem(news = testNews) {}
    }
}