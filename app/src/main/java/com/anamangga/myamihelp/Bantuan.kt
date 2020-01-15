package com.anamangga.myamihelp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_bantuan.*

class Bantuan : AppCompatActivity() {

/*    internal lateinit var btnSatpam : Button*/




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bantuan)

/*
        btnSatpam = findViewById(R.id.btn_satpam) as Button
*/

        btn_satpam.setOnClickListener {
            /*val */intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://api.whatsapp.com/send?phone=6282264700288&text=Assalamualaikum%20saya")
            startActivity(intent)
        }


         btn_clean.setOnClickListener {
            /*val */intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://api.whatsapp.com/send?phone=6282264700288&text=Assalamualaikum%20saya")
            startActivity(intent)
        }


         btn_parkir.setOnClickListener {
            /*val */intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://api.whatsapp.com/send?phone=6282264700288&text=Assalamualaikum%20saya")
            startActivity(intent)
        }


         btn_upt.setOnClickListener {
            /*val */intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://api.whatsapp.com/send?phone=6282264700288&text=Assalamualaikum%20saya")
            startActivity(intent)
        }




    }


}