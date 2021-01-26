package com.example.composekeyboardperformance.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import com.example.composekeyboardperformance.ui.Mapping
import com.example.composekeyboardperformance.ui.model.Key
import com.example.composekeyboardperformance.ui.model.Keyboard
import com.example.composekeyboardperformance.ui.components.keyboard.KeyLayout
import com.example.composekeyboardperformance.ui.theme.keyboardBackgroundColor
import java.util.*

/**
 * Am 2021-01-09 erstellt.
 */

@Composable
fun Keyboard(keyboard: Keyboard) {

    Log.d("MOVL", "DebugKeyboard:root")
    val keyboardStates =
        remember { HashMap<String, List<List<Pair<Key, ConstrainedLayoutReference>>>>() }

    Box(
        modifier = Modifier
            .background(keyboardBackgroundColor)
            .border(1.dp, Color.Yellow),
        contentAlignment = Alignment.Center
    ) {
        Log.d("MOVL", "DebugKeyboard:box")

        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .padding(2.dp)
                .graphicsLayer(clip = false)
        ) {
            Log.d("MOVL", "DebugKeyboard:constraintLayout")

            if (keyboardStates.get(keyboard.uniqueID) == null) {
                keyboardStates.put(keyboard.uniqueID, keyboard.map { row ->
                    row.map {
                        it to remember { createRef() }
                    }
                })
            }
            keyboardStates.get(keyboard.uniqueID)?.let { refs ->
                val refsMap: Map<Key, ConstrainedLayoutReference> = refs.flatten().toMap()

                refs.forEach { row ->
                    createHorizontalChain(*row.map { it.second }.toTypedArray())
                }

                keyboard.forEachIndexed { rowIndex, row ->
                    val d = (((1.0f) - row.width) / 2)
                    val startGuideline = createGuidelineFromStart(d)
                    val endGuideline = createGuidelineFromEnd(d)

                    row.forEachIndexed { columnIndex, key ->
                        val ref = refsMap[key] ?: error("Impossible state")

                        val modifier = remember {
                            Modifier
                                .constrainAs(ref) {


                                    if (columnIndex == 0) start.linkTo(
                                        startGuideline
                                    )
                                    if (columnIndex == row.lastIndex) end.linkTo(
                                        endGuideline
                                    )

                                    //Top
                                    if (rowIndex == 0) {
                                        top.linkTo(parent.top)
                                    } else {
                                        refsMap[keyboard[rowIndex - 1][0]]?.let {
                                            top.linkTo(it.bottom)
                                        }
                                    }

                                    height = Dimension.fillToConstraints

                                }
                                .fillMaxWidth(key.weight)
                        }

                        val modifierPressed = remember {
                            Modifier.constrainAs(createRef()) {
                                start.linkTo(ref.start)
                                end.linkTo(ref.end)
                                bottom.linkTo(ref.bottom)
                                width = Dimension.fillToConstraints
                            }
                        }

                        KeyLayout(
                            key = key,
                            modifier = modifier,
                            modifierPressed = modifierPressed,
                            onClick = { /*TODO*/ }
                        )

                    }

                }

            }
        }
    }
}



