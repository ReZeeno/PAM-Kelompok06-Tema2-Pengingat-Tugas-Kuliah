package id.ac.itera.pengingattugas.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import id.ac.itera.pengingattugas.data.contohDaftarTugas
import id.ac.itera.pengingattugas.model.belumSelesai
import id.ac.itera.pengingattugas.model.urutkanTenggat

@Composable
fun LayarDaftar() {
    val semua = remember { contohDaftarTugas() }
    var sembunyikanSelesai by remember { mutableStateOf(false) }

    // Olah sebelum tampil: urutkan berdasarkan tenggat, lalu (opsional) saring yang belum selesai
    val tampil = remember(sembunyikanSelesai) {
        val urut = semua.urutkanTenggat()
        if (sembunyikanSelesai) urut.belumSelesai() else urut
    }

    Scaffold(
        floatingActionButton = {
            // Belum berfungsi, sesuai ketentuan checkpoint minggu 3
            FloatingActionButton(onClick = { }) {
                Text("+", fontSize = 24.sp)
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(innerPadding)
        ) {
            Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp)) {
                Text("Pengingat Tugas Kuliah", style = MaterialTheme.typography.headlineMedium)
                Text("${semua.belumSelesai().size} tugas aktif", color = Color.Gray)
            }

            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Sembunyikan yang selesai", modifier = Modifier.weight(1f))
                Switch(
                    checked = sembunyikanSelesai,
                    onCheckedChange = { sembunyikanSelesai = it }
                )
            }

            DaftarTugas(
                semua = tampil,
                onPilih = { },
                modifier = Modifier.weight(1f),
                // bottom 88.dp supaya kartu terakhir tidak tertutup FAB
                contentPadding = PaddingValues(start = 16.dp, top = 8.dp, end = 16.dp, bottom = 88.dp)
            )
        }
    }
}