package com.tyhoo.android.nba.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tyhoo.android.nba.data.ScheduleListRepository
import com.tyhoo.android.nba.data.SchedulesGroup
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ScheduleListViewModel @Inject constructor(
    private val repository: ScheduleListRepository
) : ViewModel() {

    init {
        fetchScheduleList()
    }

    private fun fetchScheduleList() {
        viewModelScope.launch {
            val result = repository.getScheduleList()
            result.observeForever { scheduleList ->
                _scheduleList.value = scheduleList
            }
        }
    }

    private val _scheduleList = MutableLiveData<List<SchedulesGroup>>()
    val scheduleList: LiveData<List<SchedulesGroup>>
        get() = _scheduleList
}