package id.ac.itera.pengingattugas

expect fun namaPlatform(): String

fun sapaan(): String = "Pengingat Tugas Kuliah berjalan di ${namaPlatform()}"