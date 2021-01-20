package com.example.composekeyboardperformance.dsl

import com.example.composekeyboardperformance.model.KeyRow
import com.example.composekeyboardperformance.model.Keyboard

/**
 * Von Yannick Knoll am 2021-01-05 erstellt.
 */

class KeyboardBuilder : Builder<Keyboard, KeyRow>() {

    override fun create(elements: List<KeyRow>): Keyboard =
        Keyboard(elements)
}