package com.surajpatil.newbookhub.authenticate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.surajpatil.newbookhub.R

class ForgetPassordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        lateinit var btn_back_login: Button

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget_passord)

        btn_back_login = findViewById(R.id.btn_back_login)

        btn_back_login.setOnClickListener {
                Toast.makeText(this , "Back to Login Screen ! " , Toast.LENGTH_SHORT).show()
                val forpass = Intent(this@ForgetPassordActivity , LoginActivity::class.java)
                startActivity(forpass)
            }
    }
}