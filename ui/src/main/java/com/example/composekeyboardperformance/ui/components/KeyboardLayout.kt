package com.example.composekeyboardperformance.ui.components

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
import com.example.composekeyboardperformance.components.Keyboard
import com.example.composekeyboardperformance.ui.Mapping
import com.example.composekeyboardperformance.ui.Mappings
import com.example.composekeyboardperformance.ui.model.Keyboard


@Composable
fun KeyboardLayout(mappings: List<Pair<Mapping, Keyboard>>) {
    val (mapping, setMapping) = remember { mutableStateOf<Pair<Mapping, Keyboard>>(mappings[0]) }
    Column(Modifier.border(1.dp, Color.Blue)) {
        ConstraintLayout(Modifier.fillMaxWidth().border(1.dp, Color.Red)) {
            val (button, bar) = createRefs()
            createVerticalChain(button, bar)
            KeyboardBar(
                modifier = Modifier.constrainAs(bar) {
                    width = Dimension.fillToConstraints
                    start.linkTo(button.end)
                    end.linkTo(parent.end)
                },
                list = mappings.map { it.first },
                onSelected = { i, m -> setMapping(mappings[i]) },
                selected = mapping.first
            )

            BadgeButton(Modifier.constrainAs(button) {
                top.linkTo(bar.top)
                bottom.linkTo(bar.bottom)
                height = Dimension.fillToConstraints
            })

        }
        Keyboard(keyboard = mapping.second)
    }

}



