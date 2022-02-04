package com.surajpatil.theavengers20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var btn_login:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_login = findViewById(R.id.btnlogin)

    btn_login.setOnClickListener {
        Toast.makeText(this@MainActivity, "Sample Example of the Toast ! ", Toast.LENGTH_LONG).show()

        val intent = Intent(this@MainActivity, MainActivity2::class.java)
        startActivity(intent)
    }

    }
}