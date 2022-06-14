package com.surajpatil.newbookhub.authenticate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.surajpatil.newbookhub.MainActivity
import com.surajpatil.newbookhub.R

class chooseActivity : AppCompatActivity() {

    lateinit var btnlog:Button
    lateinit var btnsign:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose)

        btnlog = findViewById(R.id.btn_log)
        btnsign = findViewById(R.id.btn_si)

        btnlog.setOnClickListener {
            val intentlog = Intent(this@chooseActivity, LoginActivity::class.java)
            startActivity(intentlog)
        }

        btnsign.setOnClickListener {
            val intentsign = Intent(this@chooseActivity, RegistrationActivity::class.java)
            startActivity(intentsign)
        }


    }
}