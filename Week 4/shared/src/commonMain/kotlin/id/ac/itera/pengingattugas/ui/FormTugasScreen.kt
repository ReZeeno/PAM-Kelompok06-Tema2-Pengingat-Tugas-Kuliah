package id.ac.itera.pengingattugas.ui

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import id.ac.itera.pengingattugas.data.pilihanMataKuliah

@Composable
fun FormTugasScreen(
    onSelesai: () -> Unit,
    onBatal: () -> Unit,
    vm: FormTugasViewModel = viewModel { FormTugasViewModel() }
) {
    val state by vm.uiState.collectAsState()

    LaunchedEffect(state.tersimpan) {
        if (state.tersimpan) {
            vm.selesaiDitangani()
            onSelesai()
        }
    }

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text("Tugas baru", style = MaterialTheme.typography.headlineMedium)

            KolomTeks(
                label = "Judul",
                value = state.judul,
                onValueChange = vm::ubahJudul,
                keterangan = "${state.judul.length} dari 60 karakter"
            )

            Text("Mata kuliah", style = MaterialTheme.typography.labelLarge)
            Row(
                modifier = Modifier.horizontalScroll(rememberScrollState()),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                pilihanMataKuliah.forEach { mk ->
                    FilterChip(
                        selected = state.mataKuliah == mk,
                        onClick = { vm.pilihMataKuliah(mk) },
                        label = { Text(mk.nama) }
                    )
                }
            }

            KolomTeks(
                label = "Tenggat (yyyy-MM-dd HH:mm)",
                value = state.tenggat,
                onValueChange = vm::ubahTenggat,
                isError = state.tenggat.isNotEmpty() && !state.tenggatValid,
                keterangan = if (state.tenggat.isNotEmpty() && !state.tenggatValid)
                    "Format harus seperti 2026-11-01 23:59" else "Contoh: 2026-11-01 23:59"
            )

            KolomTeks(
                label = "Catatan (opsional)",
                value = state.catatan,
                onValueChange = vm::ubahCatatan,
                singleLine = false,
                minLines = 3
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp, alignment = androidx.compose.ui.Alignment.End)
            ) {
                TextButton(onClick = onBatal) { Text("Batal") }
                Button(onClick = vm::simpan, enabled = state.bisaSimpan) {
                    Text(if (state.sedangMenyimpan) "Menyimpan" else "Simpan")
                }
            }
        }
    }
}