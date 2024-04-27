package uz.kosimkhuja.sharipov.myweatherapp.core.utils

sealed class Screen(val route: String, val key: String) {

    data object HomeScreen: Screen("HomeScreen", "homeScreenParam")

    data object WeeklyInfoScreen: Screen("WeeklyInfoScreen", "weeklyInfoScreenParam")

}