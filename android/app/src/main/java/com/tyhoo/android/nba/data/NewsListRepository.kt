package com.tyhoo.android.nba.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NewsListRepository @Inject constructor(private val provider: NewsListDataProvider) {

    suspend fun getNewsList(): LiveData<List<NewsData>> {
        val timestamp = System.currentTimeMillis().toString()
        val newsList = MutableLiveData<List<NewsData>>()
        val list = provider.provideNewsListData(timestamp)
        newsList.postValue(list)
        return newsList
    }
}