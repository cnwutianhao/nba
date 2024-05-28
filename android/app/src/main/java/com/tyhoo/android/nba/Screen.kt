package com.tyhoo.android.nba

import androidx.annotation.StringRes
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class Screen(
    @StringRes val resourceId: Int,
    val icon: Int,
    val route: String,
    val navArguments: List<NamedNavArgument> = emptyList()
) {
    data object NewsList :
        Screen(R.string.news, R.drawable.news, "news_list")

    data object TeamList :
        Screen(R.string.teams, R.drawable.teams, "team_list")

    data object PlayerList :
        Screen(R.string.players, R.drawable.players, "player_list")

    data object ScheduleList :
        Screen(R.string.schedule, R.drawable.schedule, "schedule_list")

    data object NewsDetail : Screen(
        R.string.news_detail,
        R.drawable.news,
        "news_detail/{newsId}",
        listOf(navArgument("newsId") {
            type = NavType.StringType
        })
    ) {
        fun createRoute(newsId: String) = "news_detail/$newsId"
    }
}