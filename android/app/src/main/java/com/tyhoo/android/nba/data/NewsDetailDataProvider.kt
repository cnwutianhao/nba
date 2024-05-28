package com.tyhoo.android.nba.data

import com.tyhoo.android.nba.api.ApiService
import javax.inject.Inject

interface NewsDetailDataProvider {
    suspend fun provideNewsDetailData(newsId: String, timestamp: String): NewsDetailData
}

class NewsDetailDataProviderImpl @Inject constructor(
    private val service: ApiService
) : NewsDetailDataProvider {
    override suspend fun provideNewsDetailData(
        newsId: String, timestamp: String
    ): NewsDetailData {
        return runCatching {
            service.newsDetail(newsId = newsId, t = timestamp).data
        }.getOrElse {
            NewsDetailData("", "", "", "")
        }
    }
}