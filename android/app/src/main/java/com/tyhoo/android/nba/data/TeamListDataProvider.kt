package com.tyhoo.android.nba.data

import com.tyhoo.android.nba.api.ApiService
import javax.inject.Inject

interface TeamListDataProvider {
    suspend fun provideTeamListData(network: String, timestamp: String): TeamsData
}

class TeamListDataProviderImpl @Inject constructor(
    private val service: ApiService
) : TeamListDataProvider {
    override suspend fun provideTeamListData(
        network: String,
        timestamp: String
    ): TeamsData {
        return runCatching {
            service.teamList(network = network, t = timestamp).data
        }.getOrElse {
            TeamsData(conferences = emptyList())
        }
    }
}