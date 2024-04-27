package uz.kosimkhuja.sharipov.myweatherapp.ui.common.dialog.error

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import uz.kosimkhuja.sharipov.myweatherapp.ui.common.text.AppText

@Composable
fun AppErrorDialog(
    message: String,
    onDismiss: (() -> Unit) = {}
) = Dialog(
    onDismissRequest = onDismiss,
    properties = DialogProperties(usePlatformDefaultWidth = false)
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(18.dp)
            .background(Color.White, RoundedCornerShape(10.dp))
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        AppText(text = "Error", fontSize = 16.sp, fontWeight = FontWeight.Bold)

        AppText(text = message)

        AppText(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(elevation = 10.dp, shape = RoundedCornerShape(10.dp))
                .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                .clickable(onClick = onDismiss, role = Role.Button)
                .padding(vertical = 10.dp),
            text = "OK",
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

@Preview
@Composable
fun AppErrorDialogPreview() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        AppErrorDialog(message = "Error occurred on fetching data from remote")
    }
}