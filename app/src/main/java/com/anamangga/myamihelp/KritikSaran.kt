package com.anamangga.myamihelp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_kritik_saran.*

class KritikSaran : AppCompatActivity() {





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kritik_saran)

        btn_kirim.setOnClickListener {
            val to = input_to.text.toString().trim()
            val subject = input_subject.text.toString().trim()
            val kritikSaran = input_kritikSaran.text.toString().trim()

            kirimEmail (to, subject, kritikSaran)
        }
    }

    private fun kirimEmail (to: String, subject: String, kritikSaran: String){
        val mIntent = Intent(Intent.ACTION_SEND)
        mIntent.data = Uri.parse("mailto")
        mIntent.type = "text/plain"

        mIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(to))
        mIntent.putExtra(Intent.EXTRA_SUBJECT, subject)
        mIntent.putExtra(Intent.EXTRA_TEXT, kritikSaran)

        try{
        startActivity(Intent.createChooser(mIntent, "Choose Email Client..."))
        }
        catch (e: Exception){
            Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
        }
    }
}
