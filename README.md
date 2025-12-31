# 📱 UI-Logic Bridge

**UI-Logic Bridge** adalah proyek percontohan Android yang berfokus pada teknik fundamental dalam menghubungkan antarmuka pengguna (XML) dengan logika pemrograman (Kotlin). Proyek ini mendemonstrasikan bagaimana interaksi pengguna pada komponen visual diubah menjadi data yang dapat diproses oleh aplikasi secara interaktif dan informatif.

---

## 📖 Table of Contents

* [Overview](#-overview)
* [Key Features](#-key-features)
* [Architecture & Design](#-architecture--design)
* [Tech Stack](#-tech-stack)
* [Installation](#-installation)
* [Validation Logic](#-validation-logic)

---

## 🚀 Overview

Dalam pengembangan aplikasi Android modern, memahami keterkaitan antara file Layout dan file Activity adalah kunci utama. Proyek ini mensimulasikan skenario *input-proses-output* sederhana di mana aplikasi menerima data teks, memvalidasinya, dan memberikan respon balik secara *real-time* kepada pengguna.

Aplikasi ini tidak hanya menampilkan data, tetapi juga menangani berbagai *state* aplikasi seperti error handling ketika input kosong dan memberikan umpan balik visual melalui komponen notifikasi ringan.

---

## ✨ Key Features

### 1. ⌨️ Smart Input Handling

* **Dynamic Retrieval:** Mengambil data dari `EditText` secara efisien menggunakan teknik `findViewById`.
* **Text Processing:** Implementasi fungsi `trim()` untuk memastikan data yang diambil bersih dari spasi yang tidak perlu.
* **Auto-Focus Logic:** Sistem secara otomatis memberikan fokus kembali ke kolom input jika terjadi kesalahan validasi.

### 2. ⚠️ Advanced Validation & Feedback

* **Error Visualizer:** Memberikan peringatan visual langsung pada komponen jika input tidak memenuhi kriteria (misalnya input kosong).
* **Toast Notifications:** Memberikan konfirmasi singkat "Input diterima" setelah data berhasil diproses tanpa mengganggu alur pengguna.
* **Interactive Output:** Mengubah konten `TextView` secara dinamis berdasarkan input nama yang diberikan pengguna.

### 3. 🌓 UI State Management (Extended)

* **Theme Switching:** Mendukung perubahan mode tampilan antara *Light Mode* dan *Dark Mode* secara langsung melalui kode Kotlin.
* **Responsive Layouts:** Mengimplementasikan perbandingan antara `LinearLayout` yang statis dan `ConstraintLayout` yang fleksibel untuk berbagai ukuran layar.


---

## 🎨 Architecture & Design

Aplikasi ini dirancang dengan memisahkan struktur tampilan dan logika kontroler:

* **Structural Layer (XML):** Menggunakan `LinearLayout` untuk penyusunan elemen vertikal yang konsisten dan `ConstraintLayout` untuk desain modern yang lebih responsif.
* **Logic Layer (Kotlin):** Menangani *Event Handling* menggunakan `setOnClickListener` untuk merespons aksi klik pada tombol.
* **Bridge Mechanism:** Menggunakan ID unik (seperti `@+id/edtName`) sebagai jembatan komunikasi antara file XML dan file Kotlin.


---

## 🛠 Tech Stack

* **Language:** Kotlin 
* **UI Framework:** XML-based Layouts (View System) 
* **Min SDK:** API 21 (Android 5.0 Lollipop) 
* **IDE:** Android Studio 
* **Components:**
  * `EditText` (User Input) 
  * `Button` (Action Trigger) 
  * `TextView` (Information Display) 
  * `Toast` (Feedback) 


---

## 📦 Installation

1. **Clone the repository**
```bash
git clone https://github.com/username/P3_UI_Logic_NimAnda.git

```
2. **Open in Android Studio**
* Pastikan menggunakan versi terbaru dengan dukungan Kotlin.
3. **Sync Gradle**
* Tunggu hingga semua library pendukung seperti `AppCompat` terunduh sempurna.
4. **Run Application**
* Jalankan pada Emulator atau perangkat fisik dengan OS minimal Android 8 (Oreo).


---

## 🔒 Validation Logic

Alur logika validasi dalam aplikasi ini adalah sebagai berikut:

1. Sistem menangkap aksi klik pada `btnSubmit`.
2. Data dari `edtName` dibaca dan diperiksa kelengkapannya.
3. Jika **Kosong**: Menampilkan pesan error "Nama tidak boleh kosong!" pada kolom input.
4. Jika **Berisi**: Memperbarui `txtResult` dengan sapaan khusus dan memunculkan *Toast* konfirmasi.


---

<p align="center">
  Created by <b>Nouzaria</b>
</p>
