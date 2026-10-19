package id.ac.itera.pengingattugas.model

data class Tugas(
    val id: Int,
    val judul: String,
    val mataKuliah: MataKuliah,
    val tenggat: String,
    val catatan: String?,
    val status: StatusTugas = StatusTugas.Belum
)