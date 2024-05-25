package com.tyhoo.android.nba.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.net.URLDecoder
import java.nio.charset.StandardCharsets
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TeamListRepository @Inject constructor(private val provider: TeamListDataProvider) {

    suspend fun getTeamList(): LiveData<List<TeamsTeam>> {
        val timestamp = System.currentTimeMillis().toString()
        val network = URLDecoder.decode("N%2FA", StandardCharsets.UTF_8.name())
        val teamList = MutableLiveData<List<TeamsTeam>>()
        val list = mutableListOf<TeamsTeam>()
        val data = provider.provideTeamListData(network, timestamp)
        data.conferences.forEach { conference ->
            conference.divisions.forEach { division ->
                division.teams.forEach { team ->
                    list.add(team)
                }
            }
        }

        teamList.postValue(list)
        return teamList
    }
}