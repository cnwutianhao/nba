package com.tyhoo.android.nba.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.SvgDecoder
import com.tyhoo.android.nba.data.TeamsTeam
import com.tyhoo.android.nba.viewmodel.TeamListViewModel

@Composable
fun TeamListScreen(
    modifier: Modifier = Modifier,
    viewModel: TeamListViewModel = hiltViewModel()
) {
    val teamList by viewModel.teamList.observeAsState(initial = emptyList())
    TeamListScreen(modifier, teamList)
}

@Composable
fun TeamListScreen(
    modifier: Modifier = Modifier,
    teamList: List<TeamsTeam>
) {
    if (teamList.isNotEmpty()) {
        LazyColumn(modifier = modifier) {
            items(items = teamList) { team ->
                TeamItem(team = team)
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
fun TeamItem(team: TeamsTeam) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, bottom = 8.dp)
    ) {
        val imageUrl = "https://china.nba.cn/media/img/teams/logos/${team.abbr}_logo.svg"
        val imageLoader = ImageLoader.Builder(LocalContext.current)
            .components {
                add(SvgDecoder.Factory())
            }
            .build()
        Image(
            painter = rememberAsyncImagePainter(
                model = imageUrl,
                imageLoader = imageLoader
            ),
            contentDescription = team.name,
            modifier = Modifier
                .size(width = 150.dp, height = 150.dp)
                .padding(start = 8.dp, bottom = 8.dp)
        )

        Column(modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 8.dp, bottom = 8.dp)) {
            Text(
                text = team.city + team.name,
                style = TextStyle(fontSize = 20.sp)
            )

            Text(
                text = "缩写：" + team.abbr,
                style = TextStyle(fontSize = 16.sp),
                modifier = Modifier.padding(top = 8.dp)
            )

            Text(
                text = "城市：" + team.country + " | " + team.city,
                style = TextStyle(fontSize = 16.sp),
                modifier = Modifier.padding(top = 8.dp)
            )

            Text(
                text = "分区：" + team.conference + " | " + team.division,
                style = TextStyle(fontSize = 16.sp),
                modifier = Modifier.padding(top = 8.dp)
            )

            Text(
                text = "球馆：" + team.arenaName,
                style = TextStyle(fontSize = 16.sp),
                modifier = Modifier.padding(top = 8.dp),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Preview
@Composable
fun PreviewTeamItem() {
    val team = TeamsTeam(
        "2023",
        "1610612747",
        "湖人",
        "LAL",
        "lakers",
        "加密网球馆",
        "洛杉矶",
        "美国",
        "西部",
        "太平洋分区",
        "",
        "CA",
        "West Group A"
    )
    Box(modifier = Modifier.background(color = Color.White)) {
        TeamItem(team = team)
    }
}