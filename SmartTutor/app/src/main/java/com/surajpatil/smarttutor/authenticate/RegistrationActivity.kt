package com.surajpatil.smarttutor.authenticate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.surajpatil.smarttutor.MainActivity
import com.surajpatil.smarttutor.R

class RegistrationActivity : AppCompatActivity() {

    lateinit var btn_next_registration : Button
    lateinit var img_back : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        btn_next_registration = findViewById(R.id.btn_next_registration)
        img_back = findViewById(R.id.img_back)

        btn_next_registration.setOnClickListener {
            Toast.makeText(this, "Back to Login Screen ! ", Toast.LENGTH_SHORT).show()

            val nextLogin = Intent(this@RegistrationActivity, LoginActivity::class.java)
            startActivity(nextLogin)
        }

        img_back.setOnClickListener {
            val back = Intent(this, LoginActivity::class.java)
            startActivity(back)
        }
    }
}