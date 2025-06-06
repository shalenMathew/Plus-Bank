package com.example.bankinguiapp.bottomNav


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Wallet
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.bankinguiapp.bottomNavScreens.Screens
import com.example.bankinguiapp.ui.theme.Purple40

val items = listOf(
    BottomNavigationItem(Screens.Home.route,Icons.Rounded.Home),
    BottomNavigationItem(Screens.Wallet.route,Icons.Rounded.Wallet),
    BottomNavigationItem(Screens.Notification.route,Icons.Rounded.Notifications),
    BottomNavigationItem(Screens.Account.route,Icons.Rounded.AccountCircle)
)


@Composable
fun BottomNavigationBar(navController: NavController){

    NavigationBar{


        val navBackStackEntry by navController.currentBackStackEntryAsState() //is used to observe the current back stack entry in
        // the NavController.
        val currentRoute = navBackStackEntry?.destination?.route  // is used to get the route of the current destination in your
        // navigation graph.

        Row(modifier = Modifier.background(Color.Black)) {

         items.forEachIndexed { index, bottomNavItem ->

             NavigationBarItem(selected = currentRoute==bottomNavItem.route,
                 onClick = {
                           navController.navigate(bottomNavItem.route){
                               popUpTo(navController.graph.id){
                                   inclusive=true
                               }
                               launchSingleTop=true
                           }
                 },
                 icon = {
                     Icon(imageVector = bottomNavItem.icon ,
                         contentDescription =bottomNavItem.route,
                         tint = Color.White)
                 },
                 label = {
                     Text(text =bottomNavItem.route,
                         color = Color.White )
                 },
                 colors = NavigationBarItemDefaults.colors(
                     indicatorColor = Purple40, // This changes the color of the selected item
                 )
             )
         }
        }
    }
}

