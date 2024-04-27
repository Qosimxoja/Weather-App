package uz.kosimkhuja.sharipov.myweatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.MutableStateFlow
import uz.kosimkhuja.sharipov.data.extensions.orDoNothing
import uz.kosimkhuja.sharipov.myweatherapp.ui.common.dialog.error.AppErrorDialog
import uz.kosimkhuja.sharipov.myweatherapp.ui.screens.home.HomeScreen
import uz.kosimkhuja.sharipov.myweatherapp.ui.theme.MyMovieAppTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val errorMessage = MutableStateFlow<Throwable?>(null)
    private val onClickDialog = MutableStateFlow<(() -> Unit)?>(null)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyMovieAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colorResource(id = R.color.background)
                ) {
                    val error = errorMessage.collectAsState().value
                    val onClickDialog = onClickDialog.collectAsState().value

                    HomeScreen()

                    error?.let {
                        AppErrorDialog(
                            message = it.message.orEmpty(),
                            onDismiss = onClickDialog.orDoNothing()
                        )
                    }
                }
            }
        }
    }

    fun handleError(throwable: Throwable?, onClick: (() -> Unit)? = null) {
        errorMessage.value = throwable
        onClickDialog.value = onClick
    }
}