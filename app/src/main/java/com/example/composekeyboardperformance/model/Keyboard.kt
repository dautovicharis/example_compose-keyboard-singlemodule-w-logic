package com.example.composekeyboardperformance.model

/**
 * Von Yannick Knoll am 2021-01-05 erstellt.
 */


data class Keyboard(val rows: List<KeyRow>) : List<KeyRow> by rows