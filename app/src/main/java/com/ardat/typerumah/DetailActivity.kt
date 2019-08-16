package com.ardat.typerumah

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {

    private var txtDetaill : TextView? = null
    private var txtDeskripsi : TextView? = null
    private var kisaranHarga : TextView? = null
    private var imgRumah : ImageView? = null
    private var btnBack : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        txtDetaill = findViewById(R.id.txtDetaill) as TextView
        txtDeskripsi = findViewById(R.id.txtDeskripsi) as TextView
        kisaranHarga = findViewById(R.id.kisaranHarga) as TextView
        imgRumah = findViewById(R.id.imgRumah) as ImageView
        btnBack = findViewById(R.id.btnBack) as Button

        txtDetaill!!.text = intent.getStringExtra("nama")
        txtDeskripsi!!.text = intent.getStringExtra("deskripsi")
        kisaranHarga!!.text = intent.getStringExtra("harga")
        imgRumah!!.setImageResource(intent.getIntExtra("gambar",0))

        btnBack!!.setOnClickListener { onBackPressed() }
    }
}
