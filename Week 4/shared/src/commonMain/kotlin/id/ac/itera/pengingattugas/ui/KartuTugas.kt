package id.ac.itera.pengingattugas.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import id.ac.itera.pengingattugas.model.Tugas
import id.ac.itera.pengingattugas.model.catatanAtauDefault

@Composable
fun KartuTugas(
    tugas: Tugas,
    modifier: Modifier = Modifier,
    ringkas: Boolean = false,
    onKlik: () -> Unit = {}
) {
    Card(
        modifier = modifier.fillMaxWidth().clickable { onKlik() },
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = tugas.judul,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = tugas.mataKuliah.kode,
                    color = Color.Gray,
                    fontSize = 12.sp
                )
            }
            Text(tugas.mataKuliah.nama, color = Color.Gray)
            Text("Tenggat: ${tugas.tenggat}", color = Color.Gray)

            if (!ringkas) {
                Text("Catatan: ${tugas.catatanAtauDefault()}", fontSize = 13.sp)
            }
            LabelStatus(tugas.status)
        }
    }
}