package com.anamangga.myamihelp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private val db = FirebaseFirestore.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        auth = FirebaseAuth.getInstance()


        // Create a new user with a first and last name

        btn_daftar_daftar.setOnClickListener {
    signUpUser()


     }



        btn_masuk_daftar.setOnClickListener {
            startActivity(Intent(this, MainLogin::class.java))
        }




    }
    private fun signUpUser(){


        val passwordnya = input_pass_signin.text.toString()
        val nimnya = input_nim_signin.text.toString()
        val namanya = input_nama_signin.text.toString()

        val emailnya = input_email_signin.text.toString()
        if (input_email_signin.text.toString().isEmpty()){
            input_email_signin.error = "Tolong masukan email"
            input_email_signin.requestFocus()
            return
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(input_email_signin.text.toString()).matches()){
            input_email_signin.error = "Tolong masukan email"
            input_email_signin.requestFocus()
            return
        }

        if(input_pass_signin.text.toString().isEmpty()){
            input_pass_signin.error = "Tolong masukan NIM"
            input_pass_signin.requestFocus()
            return

        }

        auth.createUserWithEmailAndPassword(emailnya, passwordnya)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {

                    Toast.makeText(this, "Berhasil ${task.result}",
                        Toast.LENGTH_SHORT).show()
                    dataKu(auth.currentUser!!.uid.toString(), emailnya,namanya, nimnya, passwordnya)


              startActivity(Intent(this, MainLogin::class.java))
                    finish()
                }

                // ...
            }

            .addOnFailureListener {
                Toast.makeText(baseContext, "Gagal mendaftar\n${it.message}",
                    Toast.LENGTH_SHORT).show()
            }
    }

    private fun dataKu(userId: String, email: String, nama: String, nim: String, password: String){

        val dataku = hashMapOf(
            "email" to email,
            "nama" to nama,
            "nim" to nim,
            "pass" to password
        )

        db.collection("users").document(userId).set(dataku as Map<String, Any>).addOnCompleteListener {
            if(it.isSuccessful){
                Toast.makeText(this, "Sukses", Toast.LENGTH_SHORT).show()
            }
        }
            .addOnFailureListener {
                Toast.makeText(this, "Gagal\n${it.message}", Toast.LENGTH_SHORT).show()

            }

    }
}
