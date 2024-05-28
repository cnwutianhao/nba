package com.tyhoo.android.nba.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.tyhoo.android.nba.data.SchedulesGame
import com.tyhoo.android.nba.data.SchedulesGroup
import com.tyhoo.android.nba.viewmodel.ScheduleListViewModel

@Composable
fun ScheduleListScreen(
    modifier: Modifier = Modifier,
    viewModel: ScheduleListViewModel = hiltViewModel()
) {
    val scheduleList by viewModel.scheduleList.observeAsState(initial = emptyList())
    ScheduleListScreen(modifier, scheduleList)
}

@Composable
fun ScheduleListScreen(
    modifier: Modifier = Modifier,
    scheduleGroupList: List<SchedulesGroup>
) {
    if (scheduleGroupList.isNotEmpty()) {
        LazyColumn(modifier = modifier) {
            items(items = scheduleGroupList) { scheduleGroup ->
                ScheduleGroupItem(group = scheduleGroup)
                HorizontalDivider(
                    thickness = 0.5.dp,
                    color = Color.Gray,
                    modifier = Modifier.padding(start = 8.dp, end = 8.dp)
                )
            }
        }
    }
}

@Composable
fun ScheduleGroupItem(group: SchedulesGroup) {
    Column(modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 8.dp)) {
        // 日期
        Text(text = group.date, style = TextStyle(fontSize = 20.sp))

        // 赛程
        if (group.games.isNotEmpty()) {
            group.games.forEach { game ->
                ScheduleGameItem(game = game)
            }
        } else {
            Text(text = "当日没有比赛", fontSize = 14.sp)
        }
    }
}

@Composable
fun ScheduleGameItem(game: SchedulesGame) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, bottom = 8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            val homeTeamScore = if (game.statusText == "未开始") {
                "--"
            } else {
                "${game.homeTeamScore}分"
            }

            val awayTeamScore = if (game.statusText == "未开始") {
                "--"
            } else {
                "${game.awayTeamScore}分"
            }

            Text(
                text = "主队：${game.homeTeamName}(${game.homeTeamTotalWins}) $homeTeamScore",
                style = TextStyle(fontSize = 14.sp),
                modifier = Modifier.weight(1F)
            )
            Text(
                text = "客队：${game.awayTeamName}(${game.awayTeamTotalWins}) $awayTeamScore",
                style = TextStyle(fontSize = 14.sp),
                modifier = Modifier.weight(1F)
            )
        }

        Text(
            text = "状态：${game.statusText}",
            style = TextStyle(fontSize = 14.sp),
        )

        Text(
            text = "类型：${game.seasonName}",
            style = TextStyle(fontSize = 14.sp),
        )

        Text(
            text = "场馆：${game.arenaName}",
            style = TextStyle(fontSize = 14.sp),
        )
    }
}

@Preview
@Composable
fun PreviewScheduleGroupItem() {
    val testScheduleGroup = SchedulesGroup(
        "2024-05-27",
        emptyList()
    )
    Box(modifier = Modifier.background(Color.White)) {
        ScheduleGroupItem(group = testScheduleGroup)
    }
}

@Preview
@Composable
fun PreviewScheduleGameItem() {
    val testScheduleGame = SchedulesGame(
        "0042300313",
        "比赛中",
        "第一节",
        "独行侠",
        "森林狼",
        "2024-05-27",
        "08:00:00",
        "50",
        "32",
        "56",
        "26",
        "2",
        "0",
        "33",
        "28",
        "DAL",
        "MIN",
        "季后赛",
        "美航中心球馆"
    )
    Box(modifier = Modifier.background(Color.White)) {
        ScheduleGameItem(game = testScheduleGame)
    }
}