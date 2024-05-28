package com.tyhoo.android.nba.api

import com.tyhoo.android.nba.data.NBAUrls
import com.tyhoo.android.nba.data.NewsDetailResponse
import com.tyhoo.android.nba.data.NewsResponse
import com.tyhoo.android.nba.data.PlayersResponse
import com.tyhoo.android.nba.data.SchedulesResponse
import com.tyhoo.android.nba.data.TeamsResponse
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

    /**
     * 球队列表
     *
     * https://api.nba.cn/sib/v2/conference/teams?app_key=tiKB2tNdncnZFPOi&app_version=1.1.0&channel=NBA&device_id=9199617a46dae67b127c83fdb21d908d&install_id=531314079&network=N%2FA&os_type=3&os_version=1.0.0&sign=sign_v2&sign2=4F7FC9A7FDCFC1A00270E24B36730643D57F0C53CC01A0D93E67DF6C2B001FB3&t=1716544418
     */
    @GET("sib/v2/conference/teams")
    suspend fun teamList(
        @Query("app_key") appKey: String = "tiKB2tNdncnZFPOi",
        @Query("app_version") appVersion: String = "1.1.0",
        @Query("channel") channel: String = "NBA",
        @Query("device_id") deviceId: String = "9199617a46dae67b127c83fdb21d908d",
        @Query("install_id") installId: String = "531314079",
        @Query("network") network: String,
        @Query("os_type") osType: String = "3",
        @Query("os_version") osVersion: String = "1.0.0",
        @Query("sign") sign: String = "sign_v2",
        @Query("sign2") sign2: String = "4F7FC9A7FDCFC1A00270E24B36730643D57F0C53CC01A0D93E67DF6C2B001FB3",
        @Query("t") t: String
    ): TeamsResponse

    /**
     * 球员列表
     *
     * https://api.nba.cn/sib/v2/players/list?app_key=tiKB2tNdncnZFPOi&app_version=1.1.0&channel=NBA&device_id=9199617a46dae67b127c83fdb21d908d&install_id=531314079&network=N%2FA&os_type=3&os_version=1.0.0&page_no=1&page_size=1000&retireStat=A&sign=sign_v2&sign2=4F7FC9A7FDCFC1A00270E24B36730643D57F0C53CC01A0D93E67DF6C2B001FB3&t=1716431288855
     */
    @GET("sib/v2/players/list")
    suspend fun playerList(
        @Query("app_key") appKey: String = "tiKB2tNdncnZFPOi",
        @Query("app_version") appVersion: String = "1.1.0",
        @Query("channel") channel: String = "NBA",
        @Query("device_id") deviceId: String = "9199617a46dae67b127c83fdb21d908d",
        @Query("install_id") installId: String = "531314079",
        @Query("network") network: String,
        @Query("os_type") osType: String = "3",
        @Query("os_version") osVersion: String = "1.0.0",
        @Query("page_no") pageNo: String = "1",
        @Query("page_size") pageSize: String = "1000",
        @Query("retireStat") retireStat: String = "A",
        @Query("sign") sign: String = "sign_v2",
        @Query("sign2") sign2: String = "4F7FC9A7FDCFC1A00270E24B36730643D57F0C53CC01A0D93E67DF6C2B001FB3",
        @Query("t") t: String
    ): PlayersResponse

    /**
     * 赛程列表
     *
     * https://api.nba.cn/sib/v2/game/schedule?app_key=tiKB2tNdncnZFPOi&app_version=1.1.0&channel=NBA&device_id=98db0f8afd803257f2ba7476528462de&end=2024-05-31&install_id=1984047587&network=N%2FA&os_type=3&os_version=1.0.0&sign=sign_v2&sign2=FA9C061FA59F9472092B907AC5A003B74B27A6DAB65D4B7FFB47BDE5A4C8B031&start=2024-05-25&t=1716628397000
     */
    @GET("sib/v2/game/schedule")
    suspend fun scheduleList(
        @Query("app_key") appKey: String = "tiKB2tNdncnZFPOi",
        @Query("app_version") appVersion: String = "1.1.0",
        @Query("channel") channel: String = "NBA",
        @Query("device_id") deviceId: String = "98db0f8afd803257f2ba7476528462de",
        @Query("end") end: String,
        @Query("install_id") installId: String = "1984047587",
        @Query("network") network: String,
        @Query("os_type") osType: String = "3",
        @Query("os_version") osVersion: String = "1.0.0",
        @Query("sign") sign: String = "sign_v2",
        @Query("sign2") sign2: String = "FA9C061FA59F9472092B907AC5A003B74B27A6DAB65D4B7FFB47BDE5A4C8B031",
        @Query("start") start: String,
        @Query("t") t: String
    ): SchedulesResponse

    /**
     * 新闻详情
     *
     * https://china.nba.cn/cms/v1/news/info?news_id=2405171130061101&app_key=tiKB2tNdncnZFPOi&os_type=3&os_version=10.0&app_version=1.0.0&install_id=202111201544&network=wifi&t=1716165232291&device_id=6bdaac33a8df720345a767431e62caf3&channel=nba&sign=1429663966aaad6c6fd147dcccbf08f3
     */
    @GET("cms/v1/news/info")
    suspend fun newsDetail(
        @Query("news_id") newsId: String,
        @Query("app_key") appKey: String = "tiKB2tNdncnZFPOi",
        @Query("os_type") osType: String = "3",
        @Query("os_version") osVersion: String = "10.0",
        @Query("app_version") appVersion: String = "1.0.0",
        @Query("install_id") installId: String = "202111201544",
        @Query("network") network: String = "wifi",
        @Query("t") t: String,
        @Query("device_id") deviceId: String = "6bdaac33a8df720345a767431e62caf3",
        @Query("channel") channel: String = "nba",
        @Query("sign") sign: String = "1429663966aaad6c6fd147dcccbf08f3"
    ): NewsDetailResponse

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