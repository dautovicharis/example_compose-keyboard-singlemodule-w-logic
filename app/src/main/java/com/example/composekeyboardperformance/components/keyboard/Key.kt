package com.example.composekeyboardperformance.components.keyboard

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.composekeyboardperformance.model.Key
import com.example.composekeyboardperformance.theme.keyBackgroundColor


@Composable
fun Key(
    modifier: Modifier = Modifier,
    key: Key,
    popup: Boolean,
    onClick: () -> Unit,
    interactionState: InteractionState
) {
    val shape = RoundedCornerShape(4.dp)
    KeyLabel(
        modifier = modifier.clickable(
            onClick = onClick,
            indication = null ,
            interactionState = interactionState
        )
            .padding(2.dp)
            .clip(shape),
        shape = shape,
        paddingTop = 12.dp,
        paddingBottom = 12.dp,
        label = key.label,
        backgroundColor = when (key.background) {
            Key.Background.TRANSPARENT -> Color.Transparent
            Key.Background.FILLED -> keyBackgroundColor
        }
    )
}
