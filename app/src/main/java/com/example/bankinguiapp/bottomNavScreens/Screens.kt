package com.example.bankinguiapp.bottomNavScreens

sealed class Screens (val route:String){
    data object Home:Screens("Home")
    data object Wallet:Screens("Wallet")
    data object Notification:Screens("Notification")
    data object Account:Screens("Account")
}