package com.tyhoo.android.nba.api

import com.tyhoo.android.nba.data.NBAUrls
import com.tyhoo.android.nba.data.NewsResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    /**
     * 新闻列表
     *
     * https://china.nba.cn/cms/v1/news/list?column_id=57&page_size=24&page_no=1&team_ids=&last_time=&app_key=tiKB2tNdncnZFPOi&os_type=3&os_version=10.0&app_version=1.0.0&install_id=202111201544&network=wifi&t=1715908551215&device_id=6bdaac33a8df720345a767431e62caf3&channel=nba&sign=48da38cc43775e0efea30a3726328530
     */
    @GET("/cms/v1/news/list")
    suspend fun newsList(
        @Query("column_id") columnId: String = "57",
        @Query("page_size") pageSize: String = "24",
        @Query("page_no") pageNo: String = "1",
        @Query("app_key") appKey: String = "tiKB2tNdncnZFPOi",
        @Query("os_type") osType: String = "3",
        @Query("os_version") osVersion: String = "10.0",
        @Query("app_version") appVersion: String = "1.0.0",
        @Query("install_id") installId: String = "202111201544",
        @Query("network") network: String = "wifi",
        @Query("t") t: String,
        @Query("device_id") deviceId: String = "6bdaac33a8df720345a767431e62caf3",
        @Query("channel") channel: String = "nba",
        @Query("sign") sign: String = "48da38cc43775e0efea30a3726328530"
    ): NewsResponse

    companion object {
        fun create(url: NBAUrls): ApiService {
            val logger = HttpLoggingInterceptor().apply { level = Level.BASIC }
            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(url.baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)
        }
    }
}