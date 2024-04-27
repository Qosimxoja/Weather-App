package uz.kosimkhuja.sharipov.myweatherapp.ui.screens.weeklyInfo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import uz.kosimkhuja.sharipov.myweatherapp.core.utils.Screen
import uz.kosimkhuja.sharipov.myweatherapp.ui.screens.home.model.CurrencyWeatherUiParams
import uz.kosimkhuja.sharipov.myweatherapp.ui.screens.weeklyInfo.components.WeeklyInfoCurrentWeatherComponent

@Composable
fun WeeklyWeatherInfoScreen(navController: NavController) {
    val args =
        navController.previousBackStackEntry?.savedStateHandle?.get<CurrencyWeatherUiParams?>(Screen.WeeklyInfoScreen.key)

    var params: CurrencyWeatherUiParams? by remember { mutableStateOf(null) }

    LaunchedEffect(key1 = true) {
        params = args
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        WeeklyInfoCurrentWeatherComponent(modifier = Modifier.height(150.dp), params = params)
    }

}