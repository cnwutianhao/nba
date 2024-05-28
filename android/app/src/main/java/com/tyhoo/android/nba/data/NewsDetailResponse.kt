package com.tyhoo.android.nba.data

import com.google.gson.annotations.SerializedName

data class NewsDetailResponse(
    @field:SerializedName("data") val data: NewsDetailData
)

data class NewsDetailData(
    @field:SerializedName("title") val title: String,
    @field:SerializedName("thumbnail_2x") val thumbnail2x: String,
    @field:SerializedName("publish_time") val publishTime: String,
    @field:SerializedName("cnt_html") val cntHtml: String
)