package com.surajpatil.newbookhub.authenticate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.surajpatil.newbookhub.R

class SplashActivity : AppCompatActivity() {

    private lateinit var handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        handler = Handler()
        handler.postDelayed({
            val intent = Intent(this , chooseActivity::class.java)
            startActivity(intent)
            finish()

        }, 2000)

    }
}

