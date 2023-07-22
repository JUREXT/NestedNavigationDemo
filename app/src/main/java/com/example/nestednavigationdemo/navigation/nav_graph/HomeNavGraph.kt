package com.example.nestednavigationdemo.navigation.nav_graph

import android.util.Log
import androidx.navigation.*
import androidx.navigation.compose.composable
import com.example.nestednavigationdemo.navigation.DETAIL_ARGUMENT_KEY
import com.example.nestednavigationdemo.navigation.DETAIL_ARGUMENT_KEY2
import com.example.nestednavigationdemo.navigation.HOME_GRAPH_ROUTE
import com.example.nestednavigationdemo.navigation.Screen
import com.example.nestednavigationdemo.screens.DetailScreen
import com.example.nestednavigationdemo.screens.HomeScreen

fun NavGraphBuilder.homeNavGraph(
    navController: NavHostController
) {
    navigation(
        startDestination = Screen.Home.route,
        route = HOME_GRAPH_ROUTE
    ) {
        composable(
            route = Screen.Home.route
        ) {
            HomeScreen(navController = navController)
        }
        composable(
            route = Screen.Detail.route,
            arguments = listOf(
                navArgument(DETAIL_ARGUMENT_KEY) {
                    type = NavType.IntType
                    defaultValue = 0
                },
                navArgument(DETAIL_ARGUMENT_KEY2) {
                    type = NavType.StringType
                    defaultValue = "Stevdza-San"
                }
            )
        ) {backStack ->
            val key = backStack.arguments?.getInt(DETAIL_ARGUMENT_KEY)
            val key2 = backStack.arguments?.getString(DETAIL_ARGUMENT_KEY2)
            Log.d("WHAT", "Data passed to Detail: $key and $key2")
            DetailScreen(navController = navController, data = "$key, $key2")
        }
    }
}