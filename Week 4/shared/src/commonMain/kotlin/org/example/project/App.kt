package id.ac.itera.pengingattugas

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import id.ac.itera.pengingattugas.ui.FormTugasScreen
import id.ac.itera.pengingattugas.ui.LayarDaftar

@Composable
fun App() = MaterialTheme {
    var tampilForm by rememberSaveable { mutableStateOf(false) }

    if (tampilForm) {
        FormTugasScreen(
            onSelesai = { tampilForm = false },
            onBatal = { tampilForm = false }
        )
    } else {
        LayarDaftar(onTambah = { tampilForm = true })
    }
}