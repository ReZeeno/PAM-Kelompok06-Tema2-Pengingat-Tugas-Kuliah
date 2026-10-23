package id.ac.itera.pengingattugas

import id.ac.itera.pengingattugas.data.contohDaftarTugas
import id.ac.itera.pengingattugas.model.StatusTugas
import id.ac.itera.pengingattugas.model.belumSelesai
import id.ac.itera.pengingattugas.model.urutkanTenggat
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class TugasOlahTest {

    @Test
    fun daftarDummyMinimalSepuluhDenganIdUnik() {
        val daftar = contohDaftarTugas()
        assertTrue(daftar.size >= 10)
        assertEquals(daftar.size, daftar.map { it.id }.distinct().size)
    }

    @Test
    fun urutkanTenggatMenaik() {
        val tenggat = contohDaftarTugas().urutkanTenggat().map { it.tenggat }
        assertEquals(tenggat.sorted(), tenggat)
    }

    @Test
    fun belumSelesaiTidakMemuatTugasSelesai() {
        val hasil = contohDaftarTugas().belumSelesai()
        assertTrue(hasil.isNotEmpty())
        assertTrue(hasil.none { it.status is StatusTugas.Selesai })
    }
}