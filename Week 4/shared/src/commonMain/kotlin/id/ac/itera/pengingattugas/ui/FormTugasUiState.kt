package id.ac.itera.pengingattugas.ui

import id.ac.itera.pengingattugas.model.MataKuliah
private val FORMAT_TENGGAT = Regex("""\d{4}-\d{2}-\d{2} \d{2}:\d{2}""")

data class FormTugasUiState(
    val judul: String = "",
    val mataKuliah: MataKuliah? = null,
    val tenggat: String = "",
    val catatan: String = "",
    val sedangMenyimpan: Boolean = false,
    val tersimpan: Boolean = false
) {
    val judulValid: Boolean get() = judul.isNotBlank()
    val tenggatValid: Boolean get() = FORMAT_TENGGAT.matches(tenggat)
    // dihitung dari nilai lain, tidak disimpan sendiri
    val bisaSimpan: Boolean
        get() = judulValid && mataKuliah != null && tenggatValid && !sedangMenyimpan
}