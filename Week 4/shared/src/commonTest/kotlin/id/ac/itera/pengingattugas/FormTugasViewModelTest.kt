package id.ac.itera.pengingattugas

import id.ac.itera.pengingattugas.data.SumberDaftarTugasPalsu
import id.ac.itera.pengingattugas.data.pilihanMataKuliah
import id.ac.itera.pengingattugas.ui.FormTugasViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

@OptIn(ExperimentalCoroutinesApi::class)
class FormTugasViewModelTest {
    private val dispatcher = StandardTestDispatcher()
    
    @BeforeTest fun mulai() { Dispatchers.setMain(dispatcher) }
    @AfterTest fun selesai() { Dispatchers.resetMain() }
    private fun isiLengkap(vm: FormTugasViewModel) {
        vm.ubahJudul("Laporan P4")
        vm.pilihMataKuliah(pilihanMataKuliah.first())
        vm.ubahTenggat("2026-11-01 23:59")
    }
    @Test
    fun awalnyaTidakBisaSimpan() {
        val vm = FormTugasViewModel(SumberDaftarTugasPalsu(emptyList()))
        assertFalse(vm.uiState.value.bisaSimpan)
    }

    @Test
    fun tenggatSalahFormatTidakBisaSimpan() {
        val vm = FormTugasViewModel(SumberDaftarTugasPalsu(emptyList()))
        isiLengkap(vm)
        vm.ubahTenggat("1 November")
        assertFalse(vm.uiState.value.bisaSimpan)
    }
    @Test
    fun simpanTidakValidTidakMenambahData() = runTest(dispatcher) {
        val sumber = SumberDaftarTugasPalsu(emptyList())
        val vm = FormTugasViewModel(sumber)
        vm.simpan()
        advanceUntilIdle()
        assertEquals(0, sumber.daftar.value.size)
    }
    @Test
    fun simpanValidMenambahSatuTugas() = runTest(dispatcher) {
        val sumber = SumberDaftarTugasPalsu(emptyList())
        val vm = FormTugasViewModel(sumber)
        isiLengkap(vm)
        vm.simpan()
        vm.simpan()
        advanceUntilIdle()
        assertEquals(1, sumber.daftar.value.size)
        assertTrue(vm.uiState.value.tersimpan)
    }
}