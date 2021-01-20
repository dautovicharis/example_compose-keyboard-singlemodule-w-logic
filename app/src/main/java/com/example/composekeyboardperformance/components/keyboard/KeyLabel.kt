package com.example.composekeyboardperformance.components.keyboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp
import com.example.composekeyboardperformance.model.Key
import com.example.composekeyboardperformance.theme.keyLabelColor

@Composable
fun KeyLabel(
    modifier: Modifier,
    shape: Shape,
    paddingTop: Dp,
    paddingBottom: Dp,
    label: Key.Label,
    backgroundColor: Color
) {

    Box(
        modifier = modifier
            .clip(shape)
            .background(backgroundColor)
            .padding(bottom = paddingBottom, top = paddingTop),
        contentAlignment = Alignment.Center
    ) {
        when (label) {
            is Key.Label.Text -> Text(
                text = label.text,
                fontSize = 20.sp,
                color = keyLabelColor
            )
            is Key.Label.Icon -> Box(contentAlignment = Alignment.Center) {
                Text(
                    text = " ",
                    fontSize = 20.sp,
                    color = keyLabelColor
                )
                Icon(
                    imageVector = vectorResource(id = label.vectorRes),
                    tint = keyLabelColor
                )
            }
        }

    }
}