package com.tyhoo.android.nba.data

import com.google.gson.annotations.SerializedName

data class PlayersResponse(
    @field:SerializedName("data") val data: List<PlayersData>
)

data class PlayersData(
    @field:SerializedName("playerId") val playerId: String,
    @field:SerializedName("lastNameEn") val lastNameEn: String,
    @field:SerializedName("firstNameEn") val firstNameEn: String,
    @field:SerializedName("lastName") val lastName: String,
    @field:SerializedName("firstName") val firstName: String,
    @field:SerializedName("teamId") val teamId: String,
    @field:SerializedName("teamAbbr") val teamAbbr: String,
    @field:SerializedName("teamName") val teamName: String,
    @field:SerializedName("position") val position: String,
    @field:SerializedName("teamCity") val teamCity: String,
    @field:SerializedName("height") val height: String,
    @field:SerializedName("weight") val weight: String,
    @field:SerializedName("heightMetric") val heightMetric: String,
    @field:SerializedName("weightMetric") val weightMetric: String,
    @field:SerializedName("birthDate") val birthDate: String,
    @field:SerializedName("jerseyNo") val jerseyNo: String,
    @field:SerializedName("playerCode") val playerCode: String,
    @field:SerializedName("country") val country: String,
    @field:SerializedName("school") val school: String,
    @field:SerializedName("draftSeason") val draftSeason: String,
    @field:SerializedName("experience") val experience: String,
    @field:SerializedName("displayName") val displayName: String,
    @field:SerializedName("retireYear") val retireYear: String,
    @field:SerializedName("startYear") val startYear: String,
    @field:SerializedName("avatar") val avatar: String
)