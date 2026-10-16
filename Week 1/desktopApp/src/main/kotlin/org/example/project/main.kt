package org.example.project

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import id.ac.itera.pengingattugas.App

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "PengingatTugasKuliah",
    ) {
        App()
    }
}