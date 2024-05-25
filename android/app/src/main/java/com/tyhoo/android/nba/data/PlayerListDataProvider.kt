package com.tyhoo.android.nba.data

import com.tyhoo.android.nba.api.ApiService
import javax.inject.Inject

interface PlayerListDataProvider {
    suspend fun providePlayerListData(network: String, timestamp: String): List<PlayersData>
}

class PlayerListDataProviderImpl @Inject constructor(
    private val service: ApiService
) : PlayerListDataProvider {
    override suspend fun providePlayerListData(
        network: String,
        timestamp: String
    ): List<PlayersData> {
        return runCatching {
            service.playerList(network = network, t = timestamp).data
        }.getOrElse {
            emptyList()
        }
    }
}