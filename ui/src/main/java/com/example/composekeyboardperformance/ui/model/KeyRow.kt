package com.example.composekeyboardperformance.ui.model

/**
 * Am 2021-01-05 erstellt.
 */
data class KeyRow(val keys: List<Key>, val width: Float) :
    List<Key> by keys
