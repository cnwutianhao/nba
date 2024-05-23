package com.tyhoo.android.nba.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tyhoo.android.nba.data.PlayerListRepository
import com.tyhoo.android.nba.data.PlayersData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlayerListViewModel @Inject internal constructor(
    private val repository: PlayerListRepository
) : ViewModel() {

    init {
        fetchPlayerList()
    }

    private fun fetchPlayerList() {
        viewModelScope.launch {
            val result = repository.getPlayerList()
            result.observeForever { playerList ->
                _playerList.value = playerList
            }
        }
    }

    private val _playerList = MutableLiveData<List<PlayersData>>()
    val playerList: LiveData<List<PlayersData>>
        get() = _playerList
}