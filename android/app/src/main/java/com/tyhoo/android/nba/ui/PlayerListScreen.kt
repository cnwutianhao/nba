package com.tyhoo.android.nba.ui

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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.tyhoo.android.nba.data.PlayersData
import com.tyhoo.android.nba.viewmodel.PlayerListViewModel

@Composable
fun PlayerListScreen(
    modifier: Modifier = Modifier,
    viewModel: PlayerListViewModel = hiltViewModel()
) {
    val playerList by viewModel.playerList.observeAsState(initial = emptyList())
    PlayerListScreen(modifier, playerList)
}

@Composable
fun PlayerListScreen(
    modifier: Modifier = Modifier,
    playerList: List<PlayersData>
) {
    if (playerList.isNotEmpty()) {
        LazyColumn(modifier = modifier) {
            items(items = playerList) { player ->
                PlayerItem(player = player)
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
fun PlayerItem(player: PlayersData) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, bottom = 8.dp)
    ) {
        val avatarUrl = "https://res.nba.cn/media/img/players/head/260x190/${player.playerId}.png"
        AsyncImage(
            model = avatarUrl,
            contentDescription = player.playerCode,
            modifier = Modifier
                .size(156.dp, 114.dp)
                .padding(start = 8.dp)
        )

        Column(modifier = Modifier.padding(start = 8.dp, end = 8.dp, bottom = 8.dp)) {
            Text(
                text = player.firstName + "·" + player.lastName,
                style = TextStyle(fontSize = 20.sp),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Text(
                text = "所属球队： " + player.teamName,
                style = TextStyle(fontSize = 14.sp),
                modifier = Modifier.padding(top = 8.dp)
            )

            Text(
                text = "球衣号码： " + player.jerseyNo + "号",
                style = TextStyle(fontSize = 14.sp)
            )

            Text(
                text = "联盟经验： " + player.experience + "年",
                style = TextStyle(fontSize = 14.sp)
            )

            Text(
                text = "位置： " + player.position,
                style = TextStyle(fontSize = 14.sp)
            )

            Text(
                text = "国籍： " + player.country,
                style = TextStyle(fontSize = 14.sp)
            )
        }
    }
}

@Preview
@Composable
fun PreviewPlayerItem() {
    val testPlayer = PlayersData(
        "2544",
        "James",
        "LeBron",
        "詹姆斯",
        "勒布朗",
        "1610612747",
        "LAL",
        "湖人",
        "前锋",
        "Los Angeles",
        "6-9",
        "250",
        "2.06米",
        "113.4公斤",
        "1984-12-30T00:00:00+08:00",
        "23",
        "lebron_james",
        "美国",
        "St. Vincent-St. Mary HS (OH)",
        "2003",
        "20",
        "LeBron James",
        "2023",
        "2003",
        "https://ak-static.cms.nba.com/wp-content/uploads/headshots/nba/latest/260x190/2544.png"
    )
    Box(modifier = Modifier.background(color = Color.White)) {
        PlayerItem(player = testPlayer)
    }
}