package com.anamangga.myamihelp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.auth.User
import kotlinx.android.synthetic.main.activity_main_login.*
import kotlinx.android.synthetic.main.activity_pilihan.*
import java.sql.DatabaseMetaData

class PilihanActivity : AppCompatActivity() {
    private val TAG = "PilihanActivity"
    private val mAuth = FirebaseAuth.getInstance()
      private  val db = FirebaseFirestore.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pilihan)

        val namaMu = mAuth.currentUser!!.uid
        val nimMu = mAuth.currentUser!!.uid

        getProfile(namaMu)
        getNim(nimMu)

        btn_kritikSaran.setOnClickListener {
            startActivity(Intent(this, KritikSaran::class.java))
            Toast.makeText(this,"Kritik dan saran anda sangat membantu", Toast.LENGTH_SHORT).show()

            }



        btn_bantuan.setOnClickListener {

            startActivity(Intent(this ,Bantuan::class.java))

            Toast.makeText(this,"Apakah ada masalah?    Mereka siap membantu anda   Hubungi melalui whatsapp dengan menekan salah satu button", Toast.LENGTH_LONG).show()

            }



    }

    private fun getProfile (userIdKu: String){
        Log.d("AKUNKU",userIdKu)
        db.collection("users").document(userIdKu).get().addOnSuccessListener { result ->
            Log.d("AKUNKU",result.getString("nama").toString())
            namaKu.text = result.getString("nama")


        }
    }

    private fun getNim (userNimKu: String){
        Log.d("NIMKU", userNimKu)
        db.collection("users").document(userNimKu).get().addOnSuccessListener { result ->
            Log.d("NIMKU", result.getString("nim").toString())
            nimKu.text = result.getString("nim")
        }
    }

}
