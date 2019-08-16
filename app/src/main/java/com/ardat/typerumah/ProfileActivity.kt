package com.ardat.typerumah

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class ProfileActivity : AppCompatActivity(){

    private var btnBack :  Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        btnBack = findViewById(R.id.btnBack) as Button

        btnBack!!.setOnClickListener{ onBackPressed()}
    }

}
