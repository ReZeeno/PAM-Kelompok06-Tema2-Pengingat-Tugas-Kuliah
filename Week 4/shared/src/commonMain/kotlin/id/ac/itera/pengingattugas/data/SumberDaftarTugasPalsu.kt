package id.ac.itera.pengingattugas.data

import id.ac.itera.pengingattugas.model.Tugas
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SumberDaftarTugasPalsu(
    awal: List<Tugas> = contohDaftarTugas()
) : SumberDaftarTugas {

    private val _daftar = MutableStateFlow(awal)
    override val daftar: StateFlow<List<Tugas>> = _daftar.asStateFlow()

    override fun tambah(tugas: Tugas) {
        _daftar.update { it + tugas }
    }

    override fun idBerikutnya(): Int = (_daftar.value.maxOfOrNull { it.id } ?: 0) + 1
}

val sumberTugasBersama: SumberDaftarTugas = SumberDaftarTugasPalsu()