package com.example.composekeyboardperformance.ui

import android.util.Log

class Mapping(val name: String, val mapping : String) {


    companion object {
        const val ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    }


    fun map(string: Char) : String  {
        return mapping[ALPHABET.indexOf(string)].toString()
    }

    val keyboard = keyboardFor(this)
}