package id.ac.itera.pengingattugas

import id.ac.itera.pengingattugas.data.SumberTugasPalsu
import id.ac.itera.pengingattugas.model.label
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val sumber = SumberTugasPalsu()
        val mulai = System.currentTimeMillis()
        fun waktu() = "[+${System.currentTimeMillis() - mulai} ms]"

        println("=== Demo Pengingat Tugas Kuliah ===")

        println("${waktu()} Mengambil tugas dengan id 7 ...")
        val tugas = sumber.ambil(7)
        println("${waktu()} Tugas diterima")
        println("    Judul       : ${tugas.judul}")
        println("    Mata kuliah : ${tugas.mataKuliah.kode} - ${tugas.mataKuliah.nama}")
        println("    Tenggat     : ${tugas.tenggat}")
        println("    Catatan     : ${tugas.catatan ?: "-"}")

        println()
        println("${waktu()} Memantau perubahan status ...")
        sumber.pantau(7).collect { terbaru ->
            println("${waktu()} Status: ${terbaru.status.label()}")
        }

        println("${waktu()} Selesai.")
    }
}