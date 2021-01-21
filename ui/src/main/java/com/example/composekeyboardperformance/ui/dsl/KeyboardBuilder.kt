package com.example.composekeyboardperformance.ui.dsl

import com.example.composekeyboardperformance.ui.model.KeyRow
import com.example.composekeyboardperformance.ui.model.Keyboard

/**
 * Am 2021-01-05 erstellt.
 */

class KeyboardBuilder : Builder<Keyboard, KeyRow>() {

    override fun create(elements: List<KeyRow>): Keyboard =
        Keyboard(elements)
}