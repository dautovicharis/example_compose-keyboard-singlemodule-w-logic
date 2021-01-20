package com.example.composekeyboardperformance.components.keyboard

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import com.example.composekeyboardperformance.model.Key
import com.example.composekeyboardperformance.model.Keyboard
import com.example.composekeyboardperformance.theme.keyboardBackgroundColor

/**
 * Von Yannick Knoll am 2021-01-09 erstellt.
 */

@Composable
fun Keyboard(keyboard: Keyboard) {
    Box(
        modifier = Modifier
            .background(keyboardBackgroundColor)
            .border(1.dp, Color.Yellow),
        contentAlignment = Alignment.Center
    ) {

        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .padding(2.dp)
                .graphicsLayer(clip = false)
        ) {

            val refs: List<List<Pair<Key, ConstrainedLayoutReference>>> =
                keyboard.map { row ->
                    row.map {
                        it to createRef()
                    }
                }

            val refsMap: Map<Key, ConstrainedLayoutReference> =
                refs.flatten().toMap()


            refs.forEach { row ->
                createHorizontalChain(*row.map { it.second }.toTypedArray())
            }

            keyboard.forEachIndexed { rowIndex, row ->
                val d = (((1.0f) - row.width) / 2)
                val startGuideline = createGuidelineFromStart(d)
                val endGuideline = createGuidelineFromEnd(d)

                row.forEachIndexed { columnIndex, key ->
                    val ref = refsMap[key] ?: error("Impossible state")

                    val modifier = Modifier.constrainAs(ref) {


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

                    }.fillMaxWidth(key.weight)

                    val modifierPressed = Modifier.constrainAs(createRef()) {
                        start.linkTo(ref.start)
                        end.linkTo(ref.end)
                        bottom.linkTo(ref.bottom)
                        width = Dimension.fillToConstraints
                    }

                    KeyLayout(
                        key= key,
                        modifier = modifier,
                        modifierPressed = modifierPressed,
                        onClick = { /*TODO*/ }
                    )
                }

            }
        }
    }
}





