package id.ac.itera.pengingattugas.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import id.ac.itera.pengingattugas.model.Tugas

@Composable
fun DaftarTugas(
    semua: List<Tugas>,
    onPilih: (Tugas) -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(16.dp)
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = contentPadding,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(semua, key = { it.id }) { tugas ->
            KartuTugas(tugas, onKlik = { onPilih(tugas) })
        }
    }
}