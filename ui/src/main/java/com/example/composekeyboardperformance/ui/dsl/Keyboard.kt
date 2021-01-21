package com.example.composekeyboardperformance.ui.dsl

import com.example.composekeyboardperformance.ui.model.Keyboard

/**
 * Am 2021-01-05 erstellt.
 */

fun keyboard(builder: KeyboardBuilder.() -> Unit): Keyboard {
    val scope = KeyboardBuilder()
    scope.builder()
    return scope.build()
}