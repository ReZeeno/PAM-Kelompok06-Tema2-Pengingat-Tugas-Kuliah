package id.ac.itera.pengingattugas

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
val daftarAnggota = listOf(
    "Yoga Aditomo - 124140081",
    "Guntur Anggoro Rahardianto - 124140105",
    "Muhammad Radhitya Hammam - 124140189",
)

@Composable
fun Tentang() {
    Column {
        Text("Tentang", style = MaterialTheme.typography.titleMedium)
        daftarAnggota.forEach { Text(it) }
    }
}