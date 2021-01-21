package com.example.composekeyboardperformance.ui.dsl

import com.example.composekeyboardperformance.ui.model.KeyRow
import java.lang.IllegalArgumentException

/**
 * Am 2021-01-05 erstellt.
 */

const val MAX_ROW_WIDTH = 1.0f

class KeyRowBuilder(private val width: Float) :
    Builder<KeyRow, KeyRowBuilder.Key>() {


    data class Key(
        val label: com.example.composekeyboardperformance.ui.model.Key.Label,
        val action: com.example.composekeyboardperformance.ui.model.Key.Action,
        val absoluteWeight: Float,
        val animation: com.example.composekeyboardperformance.ui.model.Key.Animation = com.example.composekeyboardperformance.ui.model.Key.Animation.POPUP,
        val background: com.example.composekeyboardperformance.ui.model.Key.Background = com.example.composekeyboardperformance.ui.model.Key.Background.FILLED
    )

    init {
        if (width > MAX_ROW_WIDTH) throw IllegalArgumentException("Width is greater than $MAX_ROW_WIDTH (actual: $width)")
    }

    override fun create(elements: List<Key>): KeyRow {
        val treatAsRelativeWeight = elements.all { it.absoluteWeight < 1f }
        val absoluteWeightSum = elements.sumByDouble { it.absoluteWeight.toDouble() }
        return KeyRow(
            elements.map {
                com.example.composekeyboardperformance.ui.model.Key(
                    it.label,
                    it.action,
                    roundToNDecimalPlaces(
                        if (treatAsRelativeWeight) it.absoluteWeight / elements.size.toDouble() else it.absoluteWeight / absoluteWeightSum,
                        4
                    ) * width,
                    it.animation,
                    background = it.background
                )
            },
            width
        )
    }
}