package id.ac.itera.pengingattugas.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.ac.itera.pengingattugas.data.SumberDaftarTugas
import id.ac.itera.pengingattugas.data.sumberTugasBersama
import id.ac.itera.pengingattugas.model.MataKuliah
import id.ac.itera.pengingattugas.model.Tugas
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FormTugasViewModel(
    private val sumber: SumberDaftarTugas = sumberTugasBersama
) : ViewModel() {
    private val _uiState = MutableStateFlow(FormTugasUiState())
    val uiState: StateFlow<FormTugasUiState> = _uiState.asStateFlow()

    fun ubahJudul(teks: String) = _uiState.update { it.copy(judul = teks.take(60)) }
    fun ubahTenggat(teks: String) = _uiState.update { it.copy(tenggat = teks.take(16)) }
    fun ubahCatatan(teks: String) = _uiState.update { it.copy(catatan = teks.take(200)) }
    fun pilihMataKuliah(mk: MataKuliah) = _uiState.update { it.copy(mataKuliah = mk) }

    fun simpan() {
        val s = _uiState.value
        val mk = s.mataKuliah ?: return
        if (!s.bisaSimpan) return

        _uiState.update { it.copy(sedangMenyimpan = true) }
        viewModelScope.launch {
            delay(500)
            sumber.tambah(
                Tugas(
                    id = sumber.idBerikutnya(),
                    judul = s.judul.trim(),
                    mataKuliah = mk,
                    tenggat = s.tenggat,
                    catatan = s.catatan.ifBlank { null }
                )
            )
            _uiState.update { it.copy(sedangMenyimpan = false, tersimpan = true) }
        }
    }
    fun selesaiDitangani() {
        _uiState.value = FormTugasUiState()
    }
}