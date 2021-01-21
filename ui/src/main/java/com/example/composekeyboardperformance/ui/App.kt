package com.example.composekeyboardperformance.ui


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.composekeyboardperformance.ui.components.KeyboardLayout
import com.example.composekeyboardperformance.ui.theme.AppTheme


@Composable
fun App() {
    AppTheme {
        Column(
            modifier = Modifier
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center
        ) {
            KeyboardLayout()
        }
    }
}