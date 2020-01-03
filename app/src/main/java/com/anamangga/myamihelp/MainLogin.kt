package com.anamangga.myamihelp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main_login.*

class MainLogin : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_login)

        auth = FirebaseAuth.getInstance()





        btn_login.setOnClickListener {
           val email= input_email.text.toString()
            val password= input_password.text.toString()


            loginMasuk(email, password)


        }






        btn_signup.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
            finish()
        }

        }

    private fun loginMasuk (email: String, password: String){
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
            if(it.isSuccessful){
                startActivity(Intent(this,PilihanActivity::class.java))
                Toast.makeText(this,"Login sukses", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
            .addOnFailureListener {
                Toast.makeText(this,"Login gagal", Toast.LENGTH_SHORT).show()
            }
    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        updateUI(currentUser)
    }

    fun updateUI(currentUser : FirebaseUser?) {

    }

}
