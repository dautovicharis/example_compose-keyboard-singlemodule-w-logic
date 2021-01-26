package com.example.composekeyboardperformance.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.setContent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mappings = Mappings.all.map { it to keyboardFor(it) }
        setContent {
            App(mappings)
        }
    }
}


