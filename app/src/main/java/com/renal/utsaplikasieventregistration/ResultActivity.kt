package com.renal.utsaplikasieventregistration

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val ringkasan = findViewById<TextView>(R.id.tvRingkasan)
        val totalView = findViewById<TextView>(R.id.tvTotal)

        val satu: String =  intent.getStringExtra("nama_peserta") ?: "" // TODO-11: terima String pertama
        val dua: String = intent.getStringExtra("nama_event") ?: "" // TODO-12: terima String kedua
        val jumlah: Int = intent.getIntExtra("jumlah_tiket", 0) // TODO-13: terima Int (bukan getStringExtra)
        val total: Int = intent.getIntExtra("total_harga", 0) // TODO-14: terima Int total
        // TODO-15: tampilkan String dan jumlah pada ringkasan
        ringkasan.text = getString(
            R.string.format_ringkasan,satu, dua, jumlah
        )
        // TODO-16: tampilkan total (konversi Int ke teks hanya di UI)
        val formatRupiah = java.text.NumberFormat.getNumberInstance(
            java.util.Locale("id", "ID")
        )

    }
}