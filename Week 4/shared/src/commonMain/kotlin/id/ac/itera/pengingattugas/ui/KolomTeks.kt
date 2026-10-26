package id.ac.itera.pengingattugas.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun KolomTeks(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    keterangan: String? = null,
    isError: Boolean = false,
    singleLine: Boolean = true,
    minLines: Int = 1
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        supportingText = keterangan?.let { { Text(it) } },
        isError = isError,
        singleLine = singleLine,
        minLines = minLines,
        modifier = modifier.fillMaxWidth()
    )
}