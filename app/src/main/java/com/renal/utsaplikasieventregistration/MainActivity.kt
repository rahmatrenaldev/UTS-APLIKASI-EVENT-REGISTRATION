package com.renal.utsaplikasieventregistration

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val satu = findViewById<EditText>(R.id.etSatu)
        val dua = findViewById<EditText>(R.id.etDua)
        val jumlahView = findViewById<EditText>(R.id.etJumlah)
        val tombol = findViewById<Button>(R.id.btnHitung)

        tombol.setOnClickListener {
            val teksSatu = satu.text.toString().trim()
            val teksDua = dua.text.toString().trim()
            /*  TODO-01: konversi aman ke Int? */
            val jumlah: Int? = jumlahView.text.toString().trim().toIntOrNull()
            // TODO-02: validasi kedua String tidak kosong; beri error dan hentikan proses
            if (teksSatu.isEmpty()) {
                satu.error = getString(R.string.error_nama_peserta)
                satu.requestFocus()
                return@setOnClickListener
            }
            if (teksDua.isEmpty()) {
                dua.error = getString(R.string.error_nama_event)
                dua.requestFocus()
                return@setOnClickListener
            }
            // TODO-03: validasi Int dalam rentang 1..10; beri error dan hentikan proses
            // PENJELASAN: toIntOrNull() menghasilkan null jika input kosong atau bukan angka, sehingga tidak crash.
            if (jumlah == null || jumlah !in 1..10) {
                jumlahView.error = getString(R.string.error_jumlah_tiket)
                jumlahView.requestFocus()
                return@setOnClickListener
            }

            val tarif: Int = 75000

            // FIXME-04: hitung dengan operasi perkalian Int
            // PERBAIKAN: Menghitung total menggunakan perkalian Int.
            // PENJELASAN: Total diperoleh dari jumlah tiket dikali tarif.
            val total: Int = jumlah * tarif
            // TODO-05: buat Explicit Intent menuju ResultActivity
            val intent = Intent(this, ResultActivity::class.java)
            // TODO-06: kirim teksSatu sebagai String
            intent.putExtra("nama_peserta", teksSatu )
            // TODO-07: kirim teksDua sebagai String
            intent.putExtra("nama_event", teksDua)
            // TODO-08: kirim jumlah sebagai Int
            intent.putExtra("jumlah_tiket", jumlah)
            // TODO-09: kirim total sebagai Int
            intent.putExtra("total_harga", total)
            // TODO-10: buka Activity tujuan
            // PENJELASAN: startActivity() membuka halaman hasil setelah semua input lolos validasi.
            startActivity(intent)
        }
    }
}