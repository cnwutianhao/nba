package com.tyhoo.android.nba.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TeamListRepository @Inject constructor(private val provider: TeamListDataProvider) {

    suspend fun getTeamList(): LiveData<List<TeamsListGroup>> {
        val teamList = MutableLiveData<List<TeamsListGroup>>()
        val list = provider.provideTeamListData()
        teamList.postValue(list)
        return teamList
    }
}