package com.example.composekeyboardperformance.dsl

import com.example.composekeyboardperformance.model.Keyboard

/**
 * Von Yannick Knoll am 2021-01-05 erstellt.
 */

fun keyboard(builder: KeyboardBuilder.() -> Unit): Keyboard {
    val scope = KeyboardBuilder()
    scope.builder()
    return scope.build()
}