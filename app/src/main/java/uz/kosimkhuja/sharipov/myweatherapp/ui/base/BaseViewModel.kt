package uz.kosimkhuja.sharipov.myweatherapp.ui.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

abstract class BaseViewModel : ViewModel() {

    private val _viewState = MutableStateFlow(BaseUiModel())
    val viewState: StateFlow<BaseUiModel> = _viewState

    protected fun setLoading(loading: Boolean) {
        _viewState.value = _viewState.value.copy(isLoading = loading, error = null)
    }

    protected fun setError(throwable: Throwable) {
        _viewState.value = _viewState.value.copy(isLoading = false, error = throwable)
    }

}