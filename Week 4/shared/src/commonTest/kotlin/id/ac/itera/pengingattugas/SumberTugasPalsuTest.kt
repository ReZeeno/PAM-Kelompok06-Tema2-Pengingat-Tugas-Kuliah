package id.ac.itera.pengingattugas

import id.ac.itera.pengingattugas.data.SumberTugasPalsu
import id.ac.itera.pengingattugas.model.StatusTugas
import id.ac.itera.pengingattugas.model.label
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class SumberTugasPalsuTest {

    private val sumber = SumberTugasPalsu()

    @Test
    fun ambilMengembalikanTugasDenganIdYangDiminta() = runTest {
        val tugas = sumber.ambil(7)
        assertEquals(7, tugas.id)
        assertNull(tugas.catatan)
        assertEquals(1000, testScheduler.currentTime)
    }

    @Test
    fun ambilBersamaanSelesaiSekitar1000ms() = runTest {
        val a = async { sumber.ambil(1) }
        val b = async { sumber.ambil(2) }
        assertEquals(1, a.await().id)
        assertEquals(2, b.await().id)
        assertEquals(1000, testScheduler.currentTime)
    }

    @Test
    fun pantauMemancarkanStatusBerurutan() = runTest {
        val status = sumber.pantau(7).map { it.status }.toList()
        assertEquals(
            listOf(
                StatusTugas.Belum,
                StatusTugas.Dikerjakan(progres = 40),
                StatusTugas.Selesai(waktuSelesai = "2026-10-25 20:30")
            ),
            status
        )
        assertEquals(3500, testScheduler.currentTime)
    }

    @Test
    fun labelStatusSesuaiJenisnya() {
        assertEquals("Belum dikerjakan", StatusTugas.Belum.label())
        assertEquals("Sedang dikerjakan (40%)", StatusTugas.Dikerjakan(40).label())
        assertEquals("Selesai: kemarin", StatusTugas.Selesai("kemarin").label())
    }
}