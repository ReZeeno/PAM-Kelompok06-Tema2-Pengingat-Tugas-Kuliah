package id.ac.itera.pengingattugas.data

import id.ac.itera.pengingattugas.model.MataKuliah
import id.ac.itera.pengingattugas.model.StatusTugas
import id.ac.itera.pengingattugas.model.Tugas

private val pam = MataKuliah(kode = "IF25-22017", nama = "Pengembangan Aplikasi Mobile")
private val jarkom = MataKuliah(kode = "IF25-21008", nama = "Jaringan Komputer")
private val metpen = MataKuliah(kode = "IF41029", nama = "Metodologi Penelitian")
// Kode contoh, ganti dengan kode asli kalau perlu
private val ai = MataKuliah(kode = "IF25-IB", nama = "Inteligensi Buatan")

// Sengaja tidak berurutan supaya efek urutkanTenggat() terlihat di layar
fun contohDaftarTugas(): List<Tugas> = listOf(
    Tugas(
        id = 1,
        judul = "Laporan Praktikum Minggu-4",
        mataKuliah = jarkom,
        tenggat = "2026-10-26 23:59",
        catatan = null
    ),
    Tugas(
        id = 2,
        judul = "Checkpoint Minggu 3: Layar Daftar",
        mataKuliah = pam,
        tenggat = "2026-10-29 23:59",
        catatan = "Push ke repo kelompok beserta tangkapan layar",
        status = StatusTugas.Dikerjakan(progres = 60)
    ),
    Tugas(
        id = 3,
        judul = "Worksheet 9: Kerangka Proposal",
        mataKuliah = metpen,
        tenggat = "2026-10-30 23:59",
        catatan = null
    ),
    Tugas(
        id = 4,
        judul = "Tugas Kelompok Kasus 03",
        mataKuliah = ai,
        tenggat = "2026-11-02 23:59",
        catatan = "Dikerjakan bertiga"
    ),
    Tugas(
        id = 5,
        judul = "Latihan Compose: ProfileCard",
        mataKuliah = pam,
        tenggat = "2026-10-23 12:00",
        catatan = null,
        status = StatusTugas.Selesai(waktuSelesai = "2026-10-22 20:15")
    ),
    Tugas(
        id = 6,
        judul = "Kuis Online Jaringan Komputer",
        mataKuliah = jarkom,
        tenggat = "2026-10-24 08:00",
        catatan = "Materi DHCP dan static routing",
        status = StatusTugas.Dikerjakan(progres = 30)
    ),
    Tugas(
        id = 7,
        judul = "Revisi Bab 1 Proposal",
        mataKuliah = metpen,
        tenggat = "2026-11-05 23:59",
        catatan = null
    ),
    Tugas(
        id = 8,
        judul = "Tugas Diskusi Searching",
        mataKuliah = ai,
        tenggat = "2026-10-21 23:59",
        catatan = null,
        status = StatusTugas.Selesai(waktuSelesai = "2026-10-20 18:40")
    ),
    Tugas(
        id = 9,
        judul = "Latihan Kotlin: Collections",
        mataKuliah = pam,
        tenggat = "2026-10-25 23:59",
        catatan = "Latihan handson1",
        status = StatusTugas.Selesai(waktuSelesai = "2026-10-22 21:05")
    ),
    Tugas(
        id = 10,
        judul = "Laporan Praktikum Minggu-5",
        mataKuliah = jarkom,
        tenggat = "2026-11-02 23:59",
        catatan = null,
        status = StatusTugas.Dikerjakan(progres = 80)
    )
)