package com.surajpatil.newbookhub.authenticate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.surajpatil.newbookhub.MainActivity
import com.surajpatil.newbookhub.R

class LoginActivity : AppCompatActivity() {

    lateinit var btn_login:Button
    lateinit var txtforget :TextView
    lateinit var txtnewreg:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_login = findViewById(R.id.btn_LoginPage)
        txtforget = findViewById(R.id.txt_forget_passwordPage)
        txtnewreg = findViewById(R.id.txt_new_registrationPage)

        btn_login.setOnClickListener {
            val intent = Intent(this@LoginActivity , MainActivity::class.java)
            startActivity(intent)
        }

        txtforget.setOnClickListener {
            val intent = Intent(this@LoginActivity , ForgetPassordActivity::class.java)
            startActivity(intent)
        }

        txtnewreg.setOnClickListener {
            val intent = Intent(this@LoginActivity , RegistrationActivity::class.java)
            startActivity(intent)
        }
    }
}