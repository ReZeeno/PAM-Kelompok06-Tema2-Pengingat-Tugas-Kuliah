package id.ac.itera.pengingattugas.model

sealed class StatusTugas {
    data object Belum : StatusTugas()

    data class Dikerjakan(
        val progres: Int
    ) : StatusTugas()

    data class Selesai(
        val waktuSelesai: String
    ) : StatusTugas()
}