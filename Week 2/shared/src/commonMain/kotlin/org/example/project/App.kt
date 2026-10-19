package id.ac.itera.pengingattugas

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun App() = MaterialTheme {
    var tampilTentang by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Pengingat Tugas Kuliah", style = MaterialTheme.typography.headlineMedium)
        Text("Tema 2")
        Spacer(Modifier.height(8.dp))

        Text(sapaan())
        Spacer(Modifier.height(16.dp))

        Button(onClick = { tampilTentang = !tampilTentang }) {
            Text(if (tampilTentang) "Sembunyikan Tentang" else "Tentang")
        }
        AnimatedVisibility(tampilTentang) { Tentang() }
    }
}