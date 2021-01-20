package com.example.composekeyboardperformance.components

import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ConstraintLayout
import androidx.compose.foundation.layout.Dimension
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.composekeyboardperformance.standardkeyboard
import com.example.composekeyboardperformance.StringKeyboardBar

@Composable
fun DebugKeyboardLayoutNOVM() {
    val fonts = remember { listOf("Default", "Symbols", "Squares", "Outlined", "Gothic") }
    val (font, setFont) = remember { mutableStateOf<String>("Default") }
    Log.d("MOVL", "$font,$fonts")
    Column(Modifier.border(1.dp, Color.Blue)) {
        ConstraintLayout(Modifier.fillMaxWidth().border(1.dp, Color.Red)) {
            val (button, bar) = createRefs()
            createVerticalChain(button, bar)
            StringKeyboardBar(
                modifier = Modifier.constrainAs(bar) {
                    width = Dimension.fillToConstraints
                    start.linkTo(button.end)
                    end.linkTo(parent.end)
                },
                list = fonts,
                onSelected = setFont,
                selected = font
            )

            BadgeButton(Modifier.constrainAs(button) {
                top.linkTo(bar.top)
                bottom.linkTo(bar.bottom)
                height = Dimension.fillToConstraints
            })

        }
        DebugKeyboard(keyboard = standardkeyboard)
    }

}



