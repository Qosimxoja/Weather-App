package uz.kosimkhuja.sharipov.myweatherapp.ui.common.text

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import uz.kosimkhuja.sharipov.myweatherapp.R
import uz.kosimkhuja.sharipov.myweatherapp.ui.theme.Roboto

@Composable
fun AppText(
    modifier: Modifier = Modifier,
    text: String,
    fontSize: TextUnit = 14.sp,
    fontWeight: FontWeight = FontWeight.Normal,
    color: Color = colorResource(id = R.color.textPrimary),
    opacity: Float = 1.0f,
    fontStyle: FontStyle = FontStyle.Normal,
    fontFamily: FontFamily = Roboto,
    textDecoration: TextDecoration = TextDecoration.None,
    textAlign: TextAlign = TextAlign.Start,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    maxLines: Int = Int.MAX_VALUE,
    minLines: Int = 1
) = Text(
    modifier = modifier,
    text = text,
    fontSize = fontSize,
    fontWeight = fontWeight,
    color = color.copy(alpha = opacity),
    fontStyle = fontStyle,
    fontFamily = fontFamily,
    textDecoration = textDecoration,
    textAlign = textAlign,
    overflow = overflow,
    maxLines = maxLines,
    minLines = minLines
)

@Composable
fun AppText(
    modifier: Modifier = Modifier,
    text: AnnotatedString,
    fontSize: TextUnit = 14.sp,
    fontWeight: FontWeight = FontWeight.Normal,
    color: Color = colorResource(id = R.color.textPrimary),
    opacity: Float = 1.0f,
    fontStyle: FontStyle = FontStyle.Normal,
    fontFamily: FontFamily = Roboto,
    textDecoration: TextDecoration = TextDecoration.None,
    textAlign: TextAlign = TextAlign.Start,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    maxLines: Int = Int.MAX_VALUE,
    minLines: Int = 1
) = Text(
    modifier = modifier,
    text = text,
    fontSize = fontSize,
    fontWeight = fontWeight,
    color = color.copy(alpha = opacity),
    fontStyle = fontStyle,
    fontFamily = fontFamily,
    textDecoration = textDecoration,
    textAlign = textAlign,
    overflow = overflow,
    maxLines = maxLines,
    minLines = minLines
)