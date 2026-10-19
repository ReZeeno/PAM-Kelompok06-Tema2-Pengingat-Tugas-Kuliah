package id.ac.itera.pengingattugas.data

import id.ac.itera.pengingattugas.model.MataKuliah
import id.ac.itera.pengingattugas.model.StatusTugas
import id.ac.itera.pengingattugas.model.Tugas
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

fun contohTugas(id: Int): Tugas = Tugas(
    id = id,
    judul = "Laporan Praktikum Minggu-4",
    mataKuliah = MataKuliah(kode = "IF25-21008", nama = "Jaringan Komputer"),
    tenggat = "2026-10-26 23:59",
    catatan = null
)

class SumberTugasPalsu : Sumber<Tugas> {

    override suspend fun ambil(id: Int): Tugas {
        delay(1000)
        return contohTugas(id)
    }

    override fun pantau(id: Int): Flow<Tugas> = flow {
        val awal = contohTugas(id)
        emit(awal)
        delay(1500)
        emit(awal.copy(status = StatusTugas.Dikerjakan(progres = 40)))
        delay(2000)
        emit(awal.copy(status = StatusTugas.Selesai(waktuSelesai = "2026-10-19 12:30")))
    }
}