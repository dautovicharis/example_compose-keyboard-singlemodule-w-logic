package com.example.composekeyboardperformance.ui

import androidx.compose.runtime.produceState
import com.example.composekeyboardperformance.ui.Mapping.Companion.ALPHABET
import org.jetbrains.annotations.TestOnly
import org.junit.Test

/**
 * Von Yannick Knoll am 2021-01-25 erstellt.
 */
class Test {

    @Test
    fun mappings() {
        Mappings.all.forEach {
            println(it.mapping.size)
        }
        Mappings.all.forEach { mapping->
            print("${mapping.name}:")
            ALPHABET.forEach {
                print(mapping.map(it.toString()))
            }
            print("\n")
        }
    }

    @Test
    fun keyboards() {
        Mappings.all.forEach {
            println(keyboardFor(it))

        }
    }
}