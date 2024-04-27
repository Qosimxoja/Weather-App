package uz.kosimkhuja.sharipov.myweatherapp.ui.screens.home

import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import uz.kosimkhuja.sharipov.myweatherapp.MainActivity
import uz.kosimkhuja.sharipov.myweatherapp.R
import uz.kosimkhuja.sharipov.myweatherapp.core.constants.Constants.CONVERTOR_DATE_PATTERN
import uz.kosimkhuja.sharipov.myweatherapp.core.constants.Constants.DATE_SIMPLE_FORMAT_PATTERN
import uz.kosimkhuja.sharipov.myweatherapp.core.constants.Constants.DEGREE
import uz.kosimkhuja.sharipov.myweatherapp.core.constants.Constants.ONLY_DAY_PATTERN
import uz.kosimkhuja.sharipov.myweatherapp.core.extensions.clickWithoutRipple
import uz.kosimkhuja.sharipov.myweatherapp.core.utils.DateUtils
import uz.kosimkhuja.sharipov.myweatherapp.ui.common.loading.AppLoadingView
import uz.kosimkhuja.sharipov.myweatherapp.ui.common.lottie.AppLottieView
import uz.kosimkhuja.sharipov.myweatherapp.ui.common.text.AppText
import uz.kosimkhuja.sharipov.myweatherapp.ui.screens.home.components.HomeCurrentWeatherComponent
import uz.kosimkhuja.sharipov.myweatherapp.ui.screens.home.components.HomeWeatherByHoursView
import uz.kosimkhuja.sharipov.myweatherapp.ui.screens.home.components.HomeWeatherByHoursViewParams

enum class HomeScreenViewType {
    CURRENT, WEEKLY
}

@Composable
fun HomeScreen() {
    val activity = LocalContext.current as? MainActivity
    val viewModel = hiltViewModel<HomeScreenViewModel>()
    val viewState = viewModel.viewState.collectAsState().value
    val currentWeather = viewModel.currentWeather.collectAsState().value
    val weeklyWeather = viewModel.weeklyWeather.collectAsState().value
    val hourlyWeather = viewModel.hourlyWeather.collectAsState().value
    val viewType = viewModel.viewType.collectAsState().value

    LaunchedEffect(key1 = true) {
        viewModel.getWeatherInfo()
    }

    BackHandler {
        if (viewType == HomeScreenViewType.CURRENT)
            activity?.moveTaskToBack(true)
        else
            viewModel.changeViewType()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        HomeCurrentWeatherComponent(
            modifier = Modifier.weight(1f),
            params = currentWeather,
            type = viewType
        )

        Column(modifier = Modifier.animateContentSize()) {
            when (viewType) {
                HomeScreenViewType.CURRENT -> {
                    WeatherByHourHeaderView(onClick = viewModel::changeViewType)

                    HomeWeatherByHoursView(listOfParams = hourlyWeather)
                }

                else -> HourlyWeatherComponent(params = weeklyWeather)
            }
        }
    }

    if (viewState.isLoading) AppLoadingView()

    if (viewState.error != null) activity?.handleError(viewState.error) { viewModel.getWeatherInfo() }
}

@Composable
private fun WeatherByHourHeaderView(
    onClick: () -> Unit
) = Row(
    modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 5.dp, horizontal = 30.dp),
    horizontalArrangement = Arrangement.SpaceBetween
) {
    AppText(
        text = stringResource(R.string.today),
        fontSize = 20.sp,
        fontWeight = FontWeight.Medium
    )

    AppText(
        modifier = Modifier.clickWithoutRipple(onClick = onClick),
        text = stringResource(R.string._7_days),
        fontSize = 12.sp,
        fontWeight = FontWeight.Light
    )
}

@Composable
fun HourlyWeatherComponent(
    params: List<HomeWeatherByHoursViewParams>
) {
    val dayStartHour = "00:00"

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(vertical = 20.dp, horizontal = 40.dp)
    ) {
        items(params) { param ->
            if (param.time == dayStartHour || params.indexOf(param) == 0) {
                val headerText = DateUtils().formatRemoteDate(
                    date = param.simpleDate,
                    fromPattern = DATE_SIMPLE_FORMAT_PATTERN,
                    toPattern = ONLY_DAY_PATTERN
                )

                AppText(
                    modifier = Modifier.padding(vertical = 10.dp),
                    text = if(params.indexOf(param) == 0) stringResource(id = R.string.today) else headerText,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                AppText(
                    text = param.time,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.textSecondary)
                )

                Row(
                    modifier = Modifier.weight(1f),
                    horizontalArrangement = Arrangement.spacedBy(
                        space = 5.dp,
                        alignment = Alignment.CenterHorizontally
                    ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    AppLottieView(
                        modifier = Modifier.size(40.dp),
                        resource = param.icon
                    )

                    AppText(
                        text = param.weather,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        color = colorResource(id = R.color.textSecondary)
                    )
                }

                AppText(
                    text = buildAnnotatedString {
                        val maxDegree = param.temp.takeIf { it.length > 3 } ?: "\t${param.temp}"

                        val minDegree = "+14$DEGREE"

                        val text = maxDegree.plus(minDegree)
                        append(text)

                        addStyle(
                            style = SpanStyle(
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Medium,
                                color = colorResource(id = R.color.textSecondary)
                            ),
                            start = text.indexOf(minDegree),
                            end = text.length
                        )
                    },
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

