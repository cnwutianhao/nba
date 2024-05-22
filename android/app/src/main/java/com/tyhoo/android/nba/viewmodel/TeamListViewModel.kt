package com.tyhoo.android.nba.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tyhoo.android.nba.data.TeamsListGroup
import com.tyhoo.android.nba.data.TeamListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TeamListViewModel @Inject internal constructor(
    private val repository: TeamListRepository
) : ViewModel() {

    init {
        fetchTeamList()
    }

    private fun fetchTeamList() {
        viewModelScope.launch {
            val result = repository.getTeamList()
            result.observeForever { teamList ->
                _teamList.value = teamList
            }
        }
    }

    private val _teamList = MutableLiveData<List<TeamsListGroup>>()
    val teamList: LiveData<List<TeamsListGroup>>
        get() = _teamList
}