package com.tyhoo.android.nba.data

import com.google.gson.annotations.SerializedName

data class SchedulesResponse(
    @field:SerializedName("data") val data: SchedulesData
)

data class SchedulesData(
    @field:SerializedName("groups") val groups: List<SchedulesGroup>
)

data class SchedulesGroup(
    @field:SerializedName("date") val date: String,
    @field:SerializedName("games") val games: List<SchedulesGame>
)

data class SchedulesGame(
    @field:SerializedName("gameId") val gameId: String,
    @field:SerializedName("statusText") val statusText: String,
    @field:SerializedName("periodText") val periodText: String,
    @field:SerializedName("homeTeamName") val homeTeamName: String,
    @field:SerializedName("awayTeamName") val awayTeamName: String,
    @field:SerializedName("startDate") val startDate: String,
    @field:SerializedName("startTime") val startTime: String,
    @field:SerializedName("homeTeamWins") val homeTeamWins: String,
    @field:SerializedName("homeTeamLosses") val homeTeamLosses: String,
    @field:SerializedName("awayTeamWins") val awayTeamWins: String,
    @field:SerializedName("awayTeamLosses") val awayTeamLosses: String,
    @field:SerializedName("homeTeamTotalWins") val homeTeamTotalWins: String,
    @field:SerializedName("awayTeamTotalWins") val awayTeamTotalWins: String,
    @field:SerializedName("homeTeamScore") val homeTeamScore: String,
    @field:SerializedName("awayTeamScore") val awayTeamScore: String,
    @field:SerializedName("homeTeamAbbr") val homeTeamAbbr: String,
    @field:SerializedName("awayTeamAbbr") val awayTeamAbbr: String,
    @field:SerializedName("seasonName") val seasonName: String,
    @field:SerializedName("arenaName") val arenaName: String
)