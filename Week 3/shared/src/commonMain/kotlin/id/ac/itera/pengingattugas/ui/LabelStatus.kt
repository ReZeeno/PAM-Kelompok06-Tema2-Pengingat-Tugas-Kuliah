package id.ac.itera.pengingattugas.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import id.ac.itera.pengingattugas.model.StatusTugas
import id.ac.itera.pengingattugas.model.label

@Composable
fun LabelStatus(status: StatusTugas, modifier: Modifier = Modifier) {
    val (latar, teks) = when (status) {
        StatusTugas.Belum -> Color(0xFFF6EDCF) to Color(0xFF5C4600)
        is StatusTugas.Dikerjakan -> Color(0xFFDCE8F5) to Color(0xFF1F3F66)
        is StatusTugas.Selesai -> Color(0xFFE0EBDD) to Color(0xFF1E5A1E)
    }

    Text(
        text = status.label(),
        color = teks,
        fontSize = 12.sp,
        modifier = modifier
            .background(latar, RoundedCornerShape(50))
            .padding(horizontal = 10.dp, vertical = 4.dp)
    )
}