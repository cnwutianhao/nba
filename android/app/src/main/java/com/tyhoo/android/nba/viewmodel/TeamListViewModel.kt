package com.tyhoo.android.nba.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tyhoo.android.nba.data.TeamListRepository
import com.tyhoo.android.nba.data.TeamsTeam
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

    private val _teamList = MutableLiveData<List<TeamsTeam>>()
    val teamList: LiveData<List<TeamsTeam>>
        get() = _teamList
}