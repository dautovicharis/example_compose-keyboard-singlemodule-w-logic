package com.example.composekeyboardperformance.model

import androidx.annotation.DrawableRes

/**
 * Von Yannick Knoll am 2021-01-05 erstellt.
 */
data class Key(
    val label: Label,
    val action: Action,
    val weight: Float,
    val animation: Animation,
    val background: Background
) {

    enum class Animation {
        PRESS, POPUP
    }

    enum class Background {
        TRANSPARENT, FILLED
    }

    sealed class Label {
        data class Text(val text: String) : Label()
        data class Icon(@DrawableRes val vectorRes: Int) : Label()
    }



    sealed class Action {
        data class Input(val chars: CharArray) : Action() {
            val size get() = chars.size

            constructor(input: String) : this(input.toCharArray())

            override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (javaClass != other?.javaClass) return false

                other as Input

                if (!chars.contentEquals(other.chars)) return false
                if (size != other.size) return false

                return true
            }

            override fun hashCode(): Int {
                var result = chars.contentHashCode()
                result = 31 * result + size
                return result
            }


        }

        sealed class Perform : Action() {
            object Delete : Perform()
            object Shift : Perform()
            object Enter : Perform()
            object ChangeMode : Perform()
            object Switch : Perform()
            object Space : Perform()
        }
    }

}