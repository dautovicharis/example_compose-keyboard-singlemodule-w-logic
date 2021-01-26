package com.example.composekeyboardperformance.ui.model

import java.util.*

/**
 * Am 2021-01-05 erstellt.
 */


data class Keyboard(val rows: List<KeyRow>, val uniqueID: String = UUID.randomUUID().toString()) : List<KeyRow> by rows