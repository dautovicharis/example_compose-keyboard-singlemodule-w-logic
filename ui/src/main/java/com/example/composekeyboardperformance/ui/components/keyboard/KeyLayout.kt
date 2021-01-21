package com.example.composekeyboardperformance.ui.components.keyboard

import androidx.compose.foundation.Interaction
import androidx.compose.foundation.InteractionState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.composekeyboardperformance.ui.model.Key

/**
 * Am 2021-01-04 erstellt.
 */

@Composable
fun KeyLayout(
    key: Key,
    modifier: Modifier,
    modifierPressed: Modifier,
    onClick: () -> Unit
) {
    val interactionState = remember { InteractionState() }
    val pressed = interactionState.contains(Interaction.Pressed)
    Key(
        modifier = modifier,
        key = key,
        popup = key.animation == Key.Animation.POPUP,
        onClick = onClick,
        interactionState = interactionState,
    )
    if (pressed && key.animation == Key.Animation.POPUP) KeyOverlay(
        modifier = modifierPressed,
        label = key.label
    )

}