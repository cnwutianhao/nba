package com.tyhoo.android.nba.data

import com.google.gson.annotations.SerializedName

data class TeamsResponse(
    @field:SerializedName("data") val data: TeamsData
)

data class TeamsData(
    @field:SerializedName("conferences") val conferences: List<TeamsConference>
)

data class TeamsConference(
    @field:SerializedName("name") val name: String,
    @field:SerializedName("divisions") val divisions: List<TeamsDivision>
)

data class TeamsDivision(
    @field:SerializedName("name") val name: String,
    @field:SerializedName("teams") val teams: List<TeamsTeam>
)

data class TeamsTeam(
    @field:SerializedName("Season") val season: String,
    @field:SerializedName("TeamID") val teamId: String,
    @field:SerializedName("Name") val name: String,
    @field:SerializedName("Abbr") val abbr: String,
    @field:SerializedName("Code") val code: String,
    @field:SerializedName("Arenaname") val arenaName: String,
    @field:SerializedName("City") val city: String,
    @field:SerializedName("Country") val country: String,
    @field:SerializedName("Conference") val conference: String,
    @field:SerializedName("Division") val division: String,
    @field:SerializedName("State") val state: String,
    @field:SerializedName("Stateabbr") val stateAbbr: String,
    @field:SerializedName("IstGroup") val iStGroup: String
)