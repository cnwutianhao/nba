package com.tyhoo.android.nba.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tyhoo.android.nba.data.NewsDetailData
import com.tyhoo.android.nba.data.NewsDetailRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val repository: NewsDetailRepository
) : ViewModel() {

    init {
        val newsId = savedStateHandle.get<String>("newsId")
        fetchNewsDetail(newsId)
    }

    private fun fetchNewsDetail(newsId: String?) {
        viewModelScope.launch {
            newsId?.let { id ->
                val result = repository.getNewsDetail(id)
                result.observeForever { news ->
                    _newsDetail.value = news
                }
            }
        }
    }

    private val _newsDetail = MutableLiveData<NewsDetailData>()
    val newsDetail: LiveData<NewsDetailData>
        get() = _newsDetail
}