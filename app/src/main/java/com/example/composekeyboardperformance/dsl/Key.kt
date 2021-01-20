package com.example.composekeyboardperformance.dsl

import androidx.annotation.DrawableRes
import com.example.composekeyboardperformance.model.Key

/**
 * Von Yannick Knoll am 2021-01-05 erstellt.
 */


fun KeyRowBuilder.keys(vararg keys: String) =
    addAll(keys.map { key -> KeyRowBuilder.Key(Key.Label.Text(key), Key.Action.Input(key), 1f) })

fun KeyRowBuilder.key(
    label: String,
    input: String = label,
    weight: Float = 1f,
    animation: Key.Animation = Key.Animation.POPUP,
    background: Key.Background = Key.Background.FILLED
) =
    add(
        KeyRowBuilder.Key(
            Key.Label.Text(label),
            Key.Action.Input(input),
            weight,
            animation = animation,
            background = background
        )
    )

fun KeyRowBuilder.key(
    @DrawableRes iconRes: Int,
    input: String,
    weight: Float = 1f,
    animation: Key.Animation = Key.Animation.POPUP,
    background: Key.Background = Key.Background.FILLED
) =
    add(
        KeyRowBuilder.Key(
            Key.Label.Icon(iconRes),
            Key.Action.Input(input),
            weight,
            animation,
            background
        )
    )


fun KeyRowBuilder.key(
    @DrawableRes iconRes: Int,
    action: Key.Action.Perform,
    weight: Float = 1f,
    animation: Key.Animation = Key.Animation.POPUP,
    background: Key.Background = Key.Background.FILLED

) =
    add(KeyRowBuilder.Key(Key.Label.Icon(iconRes), action, weight, animation, background))

fun KeyRowBuilder.key(
    label: String,
    action: Key.Action.Perform,
    weight: Float = 1f,
    animation: Key.Animation = Key.Animation.POPUP,
    background: Key.Background = Key.Background.FILLED
) =
    add(KeyRowBuilder.Key(Key.Label.Text(label), action, weight, animation, background))




