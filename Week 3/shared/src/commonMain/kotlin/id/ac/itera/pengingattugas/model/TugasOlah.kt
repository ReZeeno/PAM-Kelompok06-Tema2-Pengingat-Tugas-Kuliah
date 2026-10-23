package id.ac.itera.pengingattugas.model

// Format tenggat "yyyy-MM-dd HH:mm" sehingga urutan teks sama dengan urutan waktu
fun List<Tugas>.urutkanTenggat(): List<Tugas> = sortedBy { it.tenggat }

fun List<Tugas>.belumSelesai(): List<Tugas> = filter { it.status !is StatusTugas.Selesai }