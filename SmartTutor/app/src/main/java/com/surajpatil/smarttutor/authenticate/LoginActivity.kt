package com.surajpatil.smarttutor.authenticate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.surajpatil.smarttutor.MainActivity
import com.surajpatil.smarttutor.R

class LoginActivity : AppCompatActivity() {

    lateinit var btn_Login: Button
    lateinit var txt_forget_password: TextView
    lateinit var txt_new_registration: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        title = "LOGIN PAGE"

        btn_Login = findViewById(R.id.btn_LoginPage)
        txt_forget_password = findViewById(R.id.txt_forget_passwordPage)
        txt_new_registration = findViewById(R.id.txt_new_registrationPage)

        btn_Login.setOnClickListener {
            val intent = Intent(this@LoginActivity , MainActivity::class.java)
            startActivity(intent)
        }

        txt_forget_password.setOnClickListener {
            val intentforget = Intent(this@LoginActivity , ForgetActivity::class.java)
            startActivity(intentforget)
        }

        txt_new_registration.setOnClickListener {
            val intent_registration = Intent(this@LoginActivity , RegistrationActivity::class.java)
            startActivity(intent_registration)
        }
    }
}