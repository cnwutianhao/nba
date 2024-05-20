package com.tyhoo.android.nba.data

import com.google.gson.annotations.SerializedName

data class NewsResponse(
    @field:SerializedName("code") val code: String,
    @field:SerializedName("data") val data: List<NewsData>,
    @field:SerializedName("pagination") val pagination: NewsPagination,
    @field:SerializedName("msg") val msg: String
)

data class NewsData(
    @field:SerializedName("news_id") val newsId: String,
    @field:SerializedName("title") val title: String,
    @field:SerializedName("thumbnail") val thumbnail: String,
    @field:SerializedName("thumbnail_y") val thumbnailY: String,
    @field:SerializedName("publish_time") val publishTime: String
)

data class NewsPagination(
    @field:SerializedName("total") val total: String,
    @field:SerializedName("page_no") val pageNo: String,
    @field:SerializedName("page_size") val pageSize: String
)