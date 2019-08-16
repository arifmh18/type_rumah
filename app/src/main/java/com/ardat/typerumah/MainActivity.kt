package com.ardat.typerumah

import android.app.AlertDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.CardView
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.LinearLayout
import com.ardat.typerumah.Controller.ListRumahAdapter
import com.ardat.typerumah.Controller.ModelRumah
import java.util.ArrayList

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var listType : RecyclerView? = null
    private var catalog_referensi : CardView? = null
    private var catalog_profile : CardView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init(){
        listType = findViewById(R.id.listType) as RecyclerView
        catalog_referensi = findViewById(R.id.catalog_referensi) as CardView
        catalog_profile = findViewById(R.id.catalog_profile) as CardView

        getData()

        catalog_referensi!!.setOnClickListener(this)
        catalog_profile!!.setOnClickListener(this)
    }

    private fun getData(){
        listType!!.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        listType !!.isNestedScrollingEnabled = false

        val listData = ArrayList<ModelRumah>()
        listData.add(
            ModelRumah(
                "Rumah Tipe 21",
                "rumah minimalis dengan tipe bangunan paling kecil. Jadi bisa dibilang rumah super mini. ",
                "kisaran 50jt hingga 100jt",
                R.drawable.rumah_21
            )
        )
        listData.add(
            ModelRumah(
                "Rumah Tipe 36",
                "rumah yang mempunyai luas bangunan 36 m2",
                "kisaran mulai dari 70jt",
                R.drawable.rumah_36
            )
        )
        listData.add(ModelRumah("Rumah Tipe 45",
            "Rumah type 45 artinya rumah dengan luas bangunan 45 meter persegi.",
            "kisaran mulai dari 120jt",
            R.drawable.rumah_45))
        listData.add(ModelRumah("Rumah Tipe 54",
            "Rumah type 54 artinya rumah dengan luas bangunan 54 meter persegi.",
            "berkisar antara 250 hingga 500 juta rupiah",
            R.drawable.rumah_54))
        listData.add(ModelRumah("Rumah Tipe 60",
            "Rumah Tipe 60 ini mempunyai luas tanah 60 meter persegi. ",
            "berkisar antara 400 hingga 900 juta rupiah",
            R.drawable.rumah_60))
        listData.add(ModelRumah("Rumah Tipe 70",
            "Rumah Tipe 70 ini mempunyai luas tanah 70 meter persegi. ",
            "berkisar mulai 600 juta rupiah",
            R.drawable.rumah_70))
        listData.add(ModelRumah("Rumah Tipe 120",
            "Rumah Tipe 120 ini mempunyai luas tanah 70 meter persegi.",
            "berkisar mulai 1,2 miliar rupiah",
            R.drawable.rumah_120))
        listData.add(ModelRumah("Rumah Tipe Modular",
            "Rumah modular, adalah rumah prefabrikasi yang terdiri dari beberapa bagian yang disebut modul",
            "-", R.drawable.rumah_modular))
        listData.add(ModelRumah("Rumah Kontainer",
            "rumah yang dibangun menggunakan kontainer",
            "-",
            R.drawable.rumah_container))
        listData.add(
            ModelRumah(
                "Trailer Sebagai Hunian",
                "Rumah trailer merupakan bangunan temporer yang dapat dipindah-pindahkan dengan kendaraan berat",
                "-",
                R.drawable.rumah_trailer
            )
        )
        listData.add(
            ModelRumah(
                "Model Rumah Conch House",
                "Rumah ini dibangun dengan material kayu, berbentuk persegi dan biasanya memiliki 2 lantai. Keunikan rumah ini adalah lantai rumah yang tidak menyentuh tanah",
                "-",
                R.drawable.rumah_conch
            )
        )

        var adapter = ListRumahAdapter(this, listData)
        listType!!.adapter = adapter
    }
    
    override fun onClick(v: View) {
        when(v.id){
            R.id.catalog_referensi -> {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Referensi Data")
                builder.setMessage("Web Dekorumah - 10 Tipe Model Rumah Sederhana yang Harus Kamu Tahu\n\nGoogle Image")
                builder.setPositiveButton("Ok"){dialog, _ ->
                    dialog.dismiss()
                }
                val dialog: AlertDialog = builder.create()
                dialog.show()

            }
            R.id.catalog_profile -> {
                startActivity(Intent(this, ProfileActivity::class.java))
            }
        }
    }
    
}
