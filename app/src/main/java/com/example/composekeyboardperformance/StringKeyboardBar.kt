package com.example.composekeyboardperformance

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composekeyboardperformance.components.FontItem
import com.example.composekeyboardperformance.theme.keyBackgroundColor

/**
 * Von Yannick Knoll am 2021-01-12 erstellt.
 */

@Composable
fun StringKeyboardBar(
    modifier: Modifier = Modifier,
    selected: String,
    onSelected: (String) -> Unit,
    list: List<String>
) {
    LazyRow(
        modifier = modifier
            .background(keyBackgroundColor),
        contentPadding = PaddingValues(start = 8.dp, end = 8.dp)
    ) {
        items(list) { font ->
            FontItem(label = font, onClick = { onSelected(font) }, selected = font == selected)
        }
    }
}