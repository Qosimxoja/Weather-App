package uz.kosimkhuja.sharipov.myweatherapp.core.extensions

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

@Composable
fun Modifier.clickWithoutRipple(
    enabled: Boolean = true,
    onClick: () -> Unit
) = this.clickable(
    enabled = enabled,
    interactionSource = remember { MutableInteractionSource() },
    indication = null,
    onClick = onClick
)