package com.example.composekeyboardperformance.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composekeyboardperformance.theme.keyLabelColor
import com.example.composekeyboardperformance.theme.keyboardBackgroundColor

/**
 * Von Yannick Knoll am 2021-01-12 erstellt.
 */

@Composable
fun FontItem(label: String, selected: Boolean, onClick: () -> Unit) {
    Box(contentAlignment = Alignment.Center) {
        Text(
            modifier = Modifier
                .clickable(onClick = onClick)
                .padding(vertical = 8.dp, horizontal = 4.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(if (selected) keyboardBackgroundColor else Color.Transparent)
                .padding(vertical = 4.dp, horizontal = 8.dp),
            text = label,
            fontSize = 16.sp,
            color = keyLabelColor
        )
    }
}

@Preview
@Composable
fun FontItemPreview() {
    FontItem(label = "Fonts", onClick = { }, selected = false)
}
