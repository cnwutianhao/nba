package com.tyhoo.android.nba.data

import com.google.gson.annotations.SerializedName

data class TeamsResponse(
    @field:SerializedName("payload") val payload: TeamsPayload
)

data class TeamsPayload(
    @field:SerializedName("listGroups") val listGroups: List<TeamsListGroup>
)

data class TeamsListGroup(
    @field:SerializedName("teams") val teams: List<TeamsTeam>,
    @field:SerializedName("conference") val conference: String
)

data class TeamsTeam(
    @field:SerializedName("profile") val profile: TeamsTeamProfile
)

data class TeamsTeamProfile(
    @field:SerializedName("abbr") val abbr: String,
    @field:SerializedName("city") val city: String,
    @field:SerializedName("cityEn") val cityEn: String,
    @field:SerializedName("code") val code: String,
    @field:SerializedName("conference") val conference: String,
    @field:SerializedName("displayAbbr") val displayAbbr: String,
    @field:SerializedName("displayConference") val displayConference: String,
    @field:SerializedName("division") val division: String,
    @field:SerializedName("id") val id: String,
    @field:SerializedName("name") val name: String,
    @field:SerializedName("nameEn") val nameEn: String
)