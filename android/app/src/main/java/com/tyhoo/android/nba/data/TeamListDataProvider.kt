package com.tyhoo.android.nba.data

import com.tyhoo.android.nba.api.ApiService
import javax.inject.Inject

interface TeamListDataProvider {
    suspend fun provideTeamListData(): List<TeamsListGroup>
}

class TeamListDataProviderImpl @Inject constructor(
    private val service: ApiService
) : TeamListDataProvider {
    override suspend fun provideTeamListData(): List<TeamsListGroup> {
        return service.teamList().payload.listGroups
    }
}