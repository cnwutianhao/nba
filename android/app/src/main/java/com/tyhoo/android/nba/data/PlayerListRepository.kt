package com.tyhoo.android.nba.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.net.URLDecoder
import java.nio.charset.StandardCharsets
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PlayerListRepository @Inject constructor(private val provider: PlayerListDataProvider) {

    suspend fun getPlayerList(): LiveData<List<PlayersData>> {
        val timestamp = System.currentTimeMillis().toString()
        val network = URLDecoder.decode("N%2FA", StandardCharsets.UTF_8.name())
        val playerList = MutableLiveData<List<PlayersData>>()
        val list = provider.providePlayerListData(network, timestamp)
        playerList.postValue(list)
        return playerList
    }
}