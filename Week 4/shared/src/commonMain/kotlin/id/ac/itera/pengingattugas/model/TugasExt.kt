package id.ac.itera.pengingattugas.model

fun StatusTugas.label(): String = when (this) {
    StatusTugas.Belum -> "Belum dikerjakan"
    is StatusTugas.Dikerjakan -> "Sedang dikerjakan ($progres%)"
    is StatusTugas.Selesai -> "Selesai: $waktuSelesai"
}
fun Tugas.ringkas(): String = "#$id $judul (${mataKuliah.nama}), tenggat $tenggat"

fun Tugas.catatanAtauDefault(): String = catatan ?: "Tidak ada catatan"