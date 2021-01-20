package com.example.composekeyboardperformance.components.keyboard

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composekeyboardperformance.R
import com.example.composekeyboardperformance.model.Key
import com.example.composekeyboardperformance.theme.keyBackgroundColor

@Composable
fun KeyOverlay(modifier: Modifier = Modifier, label: Key.Label) {
    val shape = RoundedCornerShape(6.dp)
    KeyLabel(
        modifier = modifier.shadow(4.dp, shape = shape),
        paddingTop = 16.dp,
        paddingBottom = 48.dp,
        label = label,
        shape = shape,
        backgroundColor = keyBackgroundColor
    )
}

@Composable
@Preview
fun KeyOverlayPreview() {
    KeyOverlay(label = Key.Label.Text("A"))
}

@Composable
@Preview
fun KeyOverlayIconPreview() {
    KeyOverlay(label = Key.Label.Icon(R.drawable.ic_keyboard_confirm))
}