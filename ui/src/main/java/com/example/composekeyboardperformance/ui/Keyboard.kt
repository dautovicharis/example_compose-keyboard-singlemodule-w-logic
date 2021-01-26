package com.example.composekeyboardperformance.ui

import com.example.composekeyboardperformance.ui.dsl.key
import com.example.composekeyboardperformance.ui.dsl.keyboard
import com.example.composekeyboardperformance.ui.dsl.row
import com.example.composekeyboardperformance.ui.model.Key


fun keyboardFor(mapping: Mapping) = keyboard {
    row(listOf('Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P').map(mapping::map))
    row(listOf('A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L').map(mapping::map), width = .9f)
    row {
        key(
            iconRes = R.drawable.ic_keyboard_arrow,
            action = Key.Action.Perform.Shift,
            weight = 2f,
            animation = Key.Animation.PRESS,
            background = Key.Background.TRANSPARENT
        )
        listOf('Z', 'X', 'C', 'V', 'B', 'N', 'M').map(mapping::map)
        key(
            iconRes = R.drawable.ic_keyboard_backspace,
            action = Key.Action.Perform.Delete,
            weight = 2f,
            animation = Key.Animation.PRESS,
            background = Key.Background.TRANSPARENT
        )
    }
    row {
        key(
            "!#1",
            action = Key.Action.Perform.ChangeMode,
            weight = 2f,
            animation = Key.Animation.PRESS,
            background = Key.Background.TRANSPARENT
        )
        key(",", input = ",", weight = 1f, background = Key.Background.TRANSPARENT)
        key(
            iconRes = R.drawable.ic_keyboard_globe,
            action = Key.Action.Perform.Switch,
            weight = 1f,
            animation = Key.Animation.PRESS,
            background = Key.Background.TRANSPARENT
        )
        key(" ", action = Key.Action.Perform.Space, weight = 4f, animation = Key.Animation.PRESS)
        key(".", input = ".", weight = 1f, background = Key.Background.TRANSPARENT)
        key(
            iconRes = R.drawable.ic_keyboard_confirm,
            action = Key.Action.Perform.Enter,
            weight = 2f,
            animation = Key.Animation.PRESS,
            background = Key.Background.TRANSPARENT
        )
    }
}