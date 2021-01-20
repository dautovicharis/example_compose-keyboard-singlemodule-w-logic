package com.example.composekeyboardperformance.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.composekeyboardperformance.R

import com.example.composekeyboardperformance.theme.keyBackgroundColor
import com.example.composekeyboardperformance.theme.keyLabelColor
import com.example.composekeyboardperformance.theme.keyboardBackgroundColor

/**
 * Von Yannick Knoll am 2021-01-12 erstellt.
 */

@Composable
fun BadgeButton(modifier: Modifier = Modifier, onClick: () -> Unit = {}) {

    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = vectorResource(id = R.drawable.ic_gear),
            modifier = Modifier
                .background(keyBackgroundColor)

                .clickable(onClick = onClick)
                .padding(14.dp),
            tint = keyLabelColor
        )
        Spacer(modifier = Modifier.fillMaxHeight().width(1.dp).background(keyboardBackgroundColor))
    }

}