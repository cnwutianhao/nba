package com.tyhoo.android.nba.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.SvgDecoder
import com.tyhoo.android.nba.data.TeamsListGroup
import com.tyhoo.android.nba.data.TeamsTeam
import com.tyhoo.android.nba.data.TeamsTeamProfile
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
    teamList: List<TeamsListGroup>
) {
    if (teamList.isNotEmpty()) {
        LazyColumn(modifier = modifier) {
            val easternTeamList = teamList[0].teams
            val westernTeamList = teamList[1].teams
            val combinedTeamList = easternTeamList + westernTeamList

            items(items = combinedTeamList) { team ->
                TeamItem(team = team)
            }
        }
    }
}

@Composable
fun TeamItem(team: TeamsTeam) {
    Row(modifier = Modifier.fillMaxWidth()) {
        val imageUrl = "https://china.nba.cn/media/img/teams/logos/${team.profile.abbr}_logo.svg"
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
            contentDescription = team.profile.name,
            modifier = Modifier
                .size(width = 150.dp, height = 150.dp)
                .padding(start = 8.dp, bottom = 8.dp)
        )

        Column(
            modifier = Modifier.height(150.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = team.profile.city + team.profile.displayAbbr,
                style = TextStyle(fontSize = 20.sp),
                modifier = Modifier.padding(start = 8.dp, end = 8.dp)
            )

            Text(
                text = team.profile.displayConference,
                style = TextStyle(fontSize = 16.sp),
                modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 8.dp)
            )

            Text(
                text = team.profile.division,
                style = TextStyle(fontSize = 16.sp),
                modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 8.dp)
            )
        }
    }
}

@Preview
@Composable
fun PreviewTeamItem() {
    val teamProfile = TeamsTeamProfile(
        "LAL",
        "洛杉矶",
        "Los Angeles",
        "lakers",
        "Western",
        "湖人",
        "西部",
        "太平洋分区",
        "1610612747",
        "湖人",
        "Lakers"
    )
    val testTeam = TeamsTeam(teamProfile)
    Box(modifier = Modifier.background(color = Color.White)) {
        TeamItem(team = testTeam)
    }
}