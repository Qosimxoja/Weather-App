package uz.kosimkhuja.sharipov.myweatherapp.ui.base

data class BaseUiModel(
    val isLoading: Boolean = false,
    val error: Throwable? = null
)