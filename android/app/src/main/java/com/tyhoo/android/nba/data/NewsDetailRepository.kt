package com.tyhoo.android.nba.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NewsDetailRepository @Inject constructor(private val provider: NewsDetailDataProvider) {

    suspend fun getNewsDetail(newsId: String): LiveData<NewsDetailData> {
        val timestamp = System.currentTimeMillis().toString()
        val newsDetailData = MutableLiveData<NewsDetailData>()
        val data = provider.provideNewsDetailData(newsId, timestamp)
        newsDetailData.postValue(data)
        return newsDetailData
    }
}