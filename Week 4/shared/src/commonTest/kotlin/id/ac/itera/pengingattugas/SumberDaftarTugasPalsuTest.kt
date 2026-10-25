package id.ac.itera.pengingattugas

import id.ac.itera.pengingattugas.data.SumberDaftarTugasPalsu
import id.ac.itera.pengingattugas.model.MataKuliah
import id.ac.itera.pengingattugas.model.Tugas
import kotlin.test.Test
import kotlin.test.assertEquals

class SumberDaftarTugasPalsuTest {
    private val mk = MataKuliah("IF25-22017", "Pengembangan Aplikasi Mobile")

    @Test
    fun idBerikutnyaPadaDaftarKosongAdalahSatu() {
        assertEquals(1, SumberDaftarTugasPalsu(emptyList()).idBerikutnya())
    }

    @Test
    fun tambahMenaikkanJumlahDanIdBerikutnya() {
        val sumber = SumberDaftarTugasPalsu(emptyList())
        sumber.tambah(Tugas(sumber.idBerikutnya(), "A", mk, "2026-11-01 10:00", null))
        sumber.tambah(Tugas(sumber.idBerikutnya(), "B", mk, "2026-11-02 10:00", null))
        assertEquals(2, sumber.daftar.value.size)
        assertEquals(3, sumber.idBerikutnya())
    }
}