package com.tyhoo.android.nba.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
    viewModel: NewsListViewModel = hiltViewModel()
) {
    val newsList by viewModel.newsList.observeAsState(initial = emptyList())
    NewsListScreen(modifier, newsList = newsList)
}

@Composable
fun NewsListScreen(
    modifier: Modifier = Modifier,
    newsList: List<NewsData>
) {
    LazyColumn(modifier = modifier) {
        items(items = newsList) { news ->
            NewsItem(news = news)
        }
    }
}

@Composable
fun NewsItem(news: NewsData) {
    Row(modifier = Modifier.fillMaxWidth()) {
        // 新闻缩略图
        AsyncImage(
            model = news.thumbnailY,
            contentDescription = news.title,
            modifier = Modifier
                .size(width = 150.dp, height = 200.dp)
                .padding(start = 8.dp, bottom = 8.dp)
        )

        Text(
            text = news.title,
            style = TextStyle(fontSize = 20.sp),
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}

@Preview
@Composable
fun PreviewNewsItem() {
    val testNews = NewsData(
        "2405011707186301",
        "2024 NBA季后赛最新对阵图",
        "https://img.nba.cn/image/nms/cms/aeccc0d5-6498-4842-a0e7-a3686c4f053f/112.jpg?auth_key=1715939100-1715939100-0-449506a2a2488039445bd6661fd1ca13&cdn_provider=110&image_process=resize,w_660&ver=0.1.6",
        "2024-05-17 14:10:36",
    )
    Box(modifier = Modifier.background(color = Color.White)) {
        NewsItem(news = testNews)
    }
}