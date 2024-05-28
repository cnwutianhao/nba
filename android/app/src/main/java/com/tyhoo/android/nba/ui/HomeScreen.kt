package com.tyhoo.android.nba.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tyhoo.android.nba.Screen

@Composable
fun HomeScreen() {
    val items = listOf(
        Screen.NewsList,
        Screen.TeamList,
        Screen.PlayerList,
        Screen.ScheduleList
    )

    val navController = rememberNavController()
    Scaffold(bottomBar = {
        BottomNavigationBar(items = items, navController = navController)
    }) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screen.NewsList.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            // 新闻列表
            composable(route = Screen.NewsList.route) {
                NewsListScreen(
                    modifier = Modifier.fillMaxSize(),
                    onNewsClick = { news ->
                        navController.navigate(
                            Screen.NewsDetail.createRoute(newsId = news.newsId)
                        )
                    }
                )
            }

            composable(Screen.TeamList.route) { TeamListScreen(modifier = Modifier.fillMaxSize()) }
            composable(Screen.PlayerList.route) { PlayerListScreen(modifier = Modifier.fillMaxSize()) }
            composable(Screen.ScheduleList.route) { ScheduleListScreen(modifier = Modifier.fillMaxSize()) }

            // 新闻详情
            composable(
                route = Screen.NewsDetail.route,
                arguments = Screen.NewsDetail.navArguments
            ) {
                NewsDetailScreen(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
fun BottomNavigationBar(items: List<Screen>, navController: NavHostController) {
    var selectedItem by remember { mutableIntStateOf(0) }
    NavigationBar {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItem == index,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                    selectedItem = index
                },
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = item.resourceId.toString(),
                        modifier = Modifier.size(24.dp)
                    )
                },
                label = {
                    Text(text = stringResource(id = item.resourceId))
                }
            )
        }
    }
}

@Preview
@Composable
fun PreviewBottomNavigationBar() {
    val items = listOf(
        Screen.NewsList,
        Screen.TeamList,
        Screen.PlayerList,
        Screen.ScheduleList
    )
    BottomNavigationBar(items = items, navController = rememberNavController())
}