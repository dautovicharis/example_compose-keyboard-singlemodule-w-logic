package com.example.composekeyboardperformance.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composekeyboardperformance.ui.Mapping
import com.example.composekeyboardperformance.ui.theme.keyBackgroundColor

/**
 * Am 2021-01-12 erstellt.
 */

@Composable
fun KeyboardBar(
    modifier: Modifier = Modifier,
    selected: Mapping,
    onSelected: (Int,Mapping) -> Unit,
    list: List<Mapping>
) {
    LazyRow(
        modifier = modifier
            .background(keyBackgroundColor),
        contentPadding = PaddingValues(start = 8.dp, end = 8.dp)
    ) {
        itemsIndexed(list) { index, font ->
            FontItem(label = font.name, onClick = { onSelected(index, font) }, selected = font == selected)
        }
    }
}