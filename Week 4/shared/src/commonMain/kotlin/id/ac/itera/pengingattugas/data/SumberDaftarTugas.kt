package id.ac.itera.pengingattugas.data

import id.ac.itera.pengingattugas.model.Tugas
import kotlinx.coroutines.flow.StateFlow

interface SumberDaftarTugas {
    val daftar: StateFlow<List<Tugas>>
    fun tambah(tugas: Tugas)
    fun idBerikutnya(): Int
}