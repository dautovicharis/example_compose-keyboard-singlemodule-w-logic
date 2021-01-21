package com.example.composekeyboardperformance.ui.dsl

import kotlin.math.round

fun roundToNDecimalPlaces(number: Double, decimalPlaces: Int): Float {
    var multiplier = 1.0f
    repeat(decimalPlaces) { multiplier *= 10f }
    return (round(number * multiplier) / multiplier).toFloat()
}
