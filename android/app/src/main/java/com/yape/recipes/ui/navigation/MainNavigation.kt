package com.yape.recipes.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yape.recipes.base.MAP_ROUTE_STRING
import com.yape.recipes.base.DETAIL_ROUTE_STRING
import com.yape.recipes.base.HOME_ROUTE_STRING
import com.yape.recipes.ui.screen.MapScreen
import com.yape.recipes.ui.screen.DetailScreen
import com.yape.recipes.ui.screen.HomeScreen

@Composable
fun MainNavigation(mainNavController: NavHostController? = null) {
    val navController = mainNavController ?: rememberNavController()
    NavHost(
        navController = navController,
        startDestination = HOME_ROUTE_STRING
    ) {
        composable(HOME_ROUTE_STRING) {
            HomeScreen(navController = navController)
        }
        composable("$DETAIL_ROUTE_STRING/{id}") {
            it.arguments?.getString("id")?.let { id ->
                DetailScreen(navController = navController, id = id.toInt())
            }
        }
        composable("$MAP_ROUTE_STRING/{origin}") {
            it.arguments?.getString("origin")?.let { origin ->
                MapScreen(navController = navController, origin = origin)
            }
        }
    }
}

