package id.ac.itera.pengingattugas

import android.os.Build

actual fun namaPlatform(): String = "Android ${Build.VERSION.SDK_INT}"