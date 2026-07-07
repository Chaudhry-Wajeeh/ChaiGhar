package com.chaighar.presentation.ui_components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.chaighar.R
import com.chaighar.presentation.navigation.Routes
import com.chaighar.presentation.theme.LightBrown
import com.chaighar.presentation.theme.LightGraySuper


@Composable
fun BottomNavbar(navController: NavController, route: String) {
    val navItems = listOf(
        NavItem("Home", R.drawable.regular_outline_home, routes = Routes.HomeScreen),
        NavItem("Cart", R.drawable.regular_outline_bag, routes = Routes.CartScreen),
        NavItem("Favorite", R.drawable.regular_outline_heart, routes = Routes.FavoriteScreen),
        NavItem("Profile", R.drawable.outline_account_circle_24, routes = Routes.ProfileScreen)
    )

    NavigationBar(
        containerColor = LightGraySuper,
        modifier = Modifier.height(115.dp)
    ) {
        navItems.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {
                    Icon(
                    painter = painterResource(item.icon),
                    contentDescription = item.title
                    ) },
                label = {Text(item.title) },
                modifier = Modifier.size(30.dp),
                onClick = {
                    navController.navigate(item.routes) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                selected = true,
                alwaysShowLabel = false,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = LightBrown,
                    selectedTextColor = LightBrown,
                    unselectedIconColor = Color.DarkGray,
                    unselectedTextColor = Color.DarkGray,
                    indicatorColor = LightBrown.copy(alpha = 0.039f)
                )
            )
        }
    }
}

data class NavItem( val title: String, val icon: Int, val routes: Routes )