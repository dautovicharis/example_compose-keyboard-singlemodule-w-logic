package com.example.composekeyboardperformance.ui.dsl

import com.example.composekeyboardperformance.ui.model.Key


/**
 * Am 2021-01-05 erstellt.
 */

fun KeyboardBuilder.row(
    width: Float = 1.0f,
    builder: KeyRowBuilder.() -> Unit
) {
    val scope = KeyRowBuilder(width)
    scope.builder()
    this.add(scope.build())
}

fun KeyboardBuilder.row(elements: List<String>, width: Float = 1.0f) {
    val scope = KeyRowBuilder(width)
    elements.forEach {
        scope.add(
            KeyRowBuilder.Key(
                Key.Label.Text(it),
                Key.Action.Input(it),
                1f
            )
        )
    }
    this.add(scope.build())
}
