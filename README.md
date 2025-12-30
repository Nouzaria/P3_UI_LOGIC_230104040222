# P3_UI_Logic - Menghubungkan UI dengan Logic

Proyek ini adalah bagian dari Modul Praktikum **Mobile Programming 2025** yang berfokus pada pengembangan aplikasi Android menggunakan **Kotlin**. Tujuan utama dari proyek ini adalah memahami bagaimana menghubungkan antarmuka pengguna (UI) yang dibuat dengan XML ke logika pemrograman di file Activity. 

## 📝 Deskripsi Proyek

Aplikasi ini merupakan studi kasus sederhana "Input Nama" di mana pengguna memasukkan teks ke dalam `EditText`, kemudian menekan tombol `Button` untuk memproses data tersebut dan menampilkannya kembali dalam bentuk sapaan interaktif pada `TextView` serta notifikasi `Toast`. 

## 🚀 Fitur Utama

* **Input Handling**: Mengambil data teks dari komponen `EditText`. 
* **Event Handling**: Mengimplementasikan `setOnClickListener` pada tombol untuk merespons aksi pengguna. 
* **Validasi Input**: Menampilkan pesan error jika input kosong dan memberikan fokus kembali ke field yang salah. 
* **Output Interaktif**: Menampilkan hasil pemrosesan ke `TextView` dan pesan singkat melalui `Toast`. 
* **Dual Layout Implementation**: Implementasi menggunakan `LinearLayout` (berurutan) dan `ConstraintLayout` (relatif/responsif). 


## 🛠️ Spesifikasi & Alat

* **IDE**: Android Studio 
* **Bahasa Pemrograman**: Kotlin 
* **Minimum SDK**: API 21: Android 5.0 (Lollipop) 
* **Layouting**: XML (LinearLayout & ConstraintLayout) 


* **Spesifikasi Perangkat (Minimum)**:
  * RAM: 8 GB (Disarankan 16 GB) 
  * Prosesor: Intel i5 / Ryzen 5 


## 📂 Struktur Kode Penting

* **`res/layout/activity_main.xml`**: Berisi definisi UI aplikasi. Menggunakan ID unik seperti `@+id/edtName`, `@+id/btnSubmit`, dan `@+id/txtResult` sebagai jembatan ke kode logika.

* **`MainActivity.kt`**: Berisi logika aplikasi, termasuk:
  * `setContentView`: Memasang layout ke Activity. 
  * `findViewById`: Menghubungkan komponen UI XML ke variabel Kotlin. 
  * `trim()` & `isEmpty()`: Untuk pengolahan dan validasi string input. 


## 📸 Tampilan Aplikasi

| Layout | Deskripsi |
| --- | --- |
| **LinearLayout** | Elemen diatur secara vertikal dari atas ke bawah. |
| **ConstraintLayout** | Elemen diposisikan secara relatif terhadap parent atau komponen lain, lebih fleksibel untuk desain modern. |

> **Catatan**: Hasil running aplikasi akan menampilkan pesan "Halo, [Nama]! Selamat datang di Praktikum 3" setelah tombol diklik.


## 🔧 Cara Menjalankan

1. Clone repository ini atau buka folder proyek di **Android Studio**.
2. Pastikan Gradle selesai melakukan sinkronisasi (*Sync Project with Gradle Files*).
3. Pilih emulator (AVD) atau hubungkan perangkat Android fisik. 
4. Klik tombol **Run** (Ikon Play hijau).

## ⚠️ Troubleshooting Umum

* **NullPointerException**: Pastikan `findViewById` dipanggil **setelah** `setContentView`. 
* **ID Tidak Ditemukan**: Periksa kembali apakah ID di file XML sudah sama persis dengan yang dipanggil di file Kotlin. 
* **Logcat**: Gunakan fitur Logcat di Android Studio untuk melacak pesan error lebih detail. 


---

**Dosen Pengampu:** Muhayat, M.IT 

**Tahun:** 2025 
