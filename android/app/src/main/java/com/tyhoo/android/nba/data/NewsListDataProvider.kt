package com.tyhoo.android.nba.data

import com.tyhoo.android.nba.api.ApiService
import javax.inject.Inject

interface NewsListDataProvider {
    suspend fun provideNewsListData(timestamp: String): List<NewsData>
}

class NewsListDataProviderImpl @Inject constructor(
    private val service: ApiService
) : NewsListDataProvider {
    override suspend fun provideNewsListData(timestamp: String): List<NewsData> {
        return runCatching {
            service.newsList(t = timestamp).data
        }.getOrElse {
            emptyList()
        }
    }
}