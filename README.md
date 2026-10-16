# Pengingat Tugas Kuliah

**Tema 2 | PAM Kelompok 06**

Aplikasi Kotlin Multiplatform dengan Compose Multiplatform yang menargetkan Android dan Desktop (JVM).

Proyek kelompok mata kuliah **IF25-22017 Pengembangan Aplikasi Mobile**, Program Studi Teknik Informatika, Fakultas Teknologi Industri, Institut Teknologi Sumatera (ITERA).
Dosen pengampu: Muhammad Habib Algifari, S.Kom., M.T.I.

## Tema

**Tema 2: Pengingat Tugas Kuliah**

## Anggota Kelompok

Ketua kelompok:Yoga Aditomo

| No | Nama                         | NIM       |
|----|------------------------------|-----------|
| 1  | Yoga Aditomo                 | 124140081 |
| 2  | Guntur Anggoro Rahardianto   | 124140105 |
| 3  | Muhammad Radhitya Hammam     | 124140189 |

## Tangkapan Layar

| Android | Desktop |
|---------|---------|
| ![Android](screenshots/android.png) | <img width="591" height="445" alt="SS Desktop" src="https://github.com/user-attachments/assets/6e11b34f-4933-4dca-9648-62861ac80460" />|

## Isi Aplikasi Saat Ini

- Layar utama menampilkan judul "Pengingat Tugas Kuliah" dan "Tema 2".
- Kalimat sapaan yang menyebut nama platform tempat aplikasi berjalan, misalnya "Pengingat Tugas Kuliah berjalan di Desktop JVM".
- Tombol **Tentang** untuk menampilkan atau menyembunyikan daftar nama dan NIM anggota kelompok.

## Teknologi

| Komponen                | Versi         |
|-------------------------|---------------|
| Kotlin                  | 2.4.20        |
| Compose Multiplatform   | 1.12.1        |
| Material 3              | 1.12.0-alpha03 |
| Android Gradle Plugin   | 9.1.1         |
| Gradle                  | 9.5.1         |
| Android minSdk          | 24            |
| Android compileSdk / targetSdk | 37     |

Daftar versi library ada di `gradle/libs.versions.toml`.

## Prasyarat

| Kebutuhan       | Minimal                                                    |
|-----------------|------------------------------------------------------------|
| RAM             | 8 GB, disarankan 16 GB                                     |
| Ruang kosong    | 20 GB                                                      |
| Sistem operasi  | Windows 10 atau 11, macOS 12 ke atas, atau Linux           |

Perangkat lunak yang dibutuhkan:

- JDK 17 ke atas
- Android Studio dengan plugin Kotlin Multiplatform
- Git
- Xcode (hanya untuk yang memakai Mac)

RAM 8 GB masih bisa, tetapi emulator akan terasa berat. Target desktop jadi alternatif yang lebih ringan.

## Struktur Proyek

```
PengingatTugasKuliah/
  androidApp/                  Aplikasi Android (MainActivity)
  desktopApp/                  Aplikasi desktop (main.kt)
  shared/
    src/
      commonMain/kotlin/       Kode untuk semua platform
      androidMain/kotlin/      Kode khusus Android
      jvmMain/kotlin/          Kode khusus Desktop (JVM)
      commonTest/              Test untuk semua platform
      androidHostTest/         Test Android
      jvmTest/                 Test Desktop
  gradle/libs.versions.toml    Daftar versi library
  build.gradle.kts
  settings.gradle.kts
```

| Folder       | Isinya                                                        |
|--------------|---------------------------------------------------------------|
| `commonMain` | Kode untuk semua platform (`App.kt`, `Platform.kt`, `Tentang.kt`) |
| `androidMain`| Kode khusus Android                                           |
| `jvmMain`    | Kode khusus Desktop (JVM)                                     |

## Kode Bersama dan Kode Khusus (expect dan actual)

Di `commonMain` kita hanya berjanji ada fungsi `namaPlatform()` lewat `expect`. Setiap platform menepati janji itu dengan `actual` miliknya sendiri.

`commonMain/Platform.kt`

```kotlin
expect fun namaPlatform(): String

fun sapaan(): String = "Pengingat Tugas Kuliah berjalan di ${namaPlatform()}"
```

`androidMain/Platform.android.kt`

```kotlin
actual fun namaPlatform(): String = "Android ${Build.VERSION.SDK_INT}"
```

`jvmMain/Platform.jvm.kt`

```kotlin
actual fun namaPlatform(): String = "Desktop JVM"
```

## Cara Menjalankan

1. Clone repository ini, lalu buka foldernya di Android Studio.
2. Tunggu Gradle sync selesai. Unduhan pertama bisa lama, pastikan koneksi stabil.
3. Jalankan lewat run configuration di toolbar IDE, atau lewat terminal:

**Android**

```
./gradlew :androidApp:assembleDebug
```

**Desktop** (paling cepat untuk mencoba tanpa emulator)

```
# Hot reload
./gradlew :desktopApp:hotRun --auto

# Run biasa
./gradlew :desktopApp:run
```

## Menjalankan Test

```
# Android
./gradlew :shared:testAndroidHostTest

# Desktop
./gradlew :shared:jvmTest

```

## Kalau Gradle Rewel

| Pesan error              | Penyebab                              | Yang dicoba                         |
|--------------------------|---------------------------------------|-------------------------------------|
| Gradle sync failed       | JDK atau SDK tidak ditemukan          | Periksa `JAVA_HOME` dan `ANDROID_HOME` |
| SDK location not found   | Berkas `local.properties` belum ada   | Buat berkas itu berisi `sdk.dir`    |
| Kotlin version mismatch  | Versi Kotlin dan Compose tidak cocok  | Samakan versi di `libs.versions.toml` |

## Referensi

- [Kotlin Multiplatform Wizard](https://kmp.jetbrains.com)
- [Expected and actual declarations, kotlinlang.org](https://kotlinlang.org/docs/multiplatform-expect-actual.html)
- [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)
- Materi: Pertemuan 1, Kenalan dengan KMP dan Siapkan Alat
