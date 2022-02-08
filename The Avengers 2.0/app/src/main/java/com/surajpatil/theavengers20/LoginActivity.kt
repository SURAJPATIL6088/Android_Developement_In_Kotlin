package com.surajpatil.theavengers20

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    lateinit var btnlogin:Button
    lateinit var txt_forget_pass:TextView
    lateinit var et_mobilenumber:EditText
    lateinit var et_password: EditText

    val validMobileNumber = "0123456789"
    val validMobilePass = arrayOf("tony", "thor", "hulk", "common")

    lateinit var sharedprefernced:SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        sharedprefernced = getSharedPreferences(
            getString(R.string.preference_file_avengers) ,
            Context.MODE_PRIVATE
        )
        val isLoggedIn = sharedprefernced.getBoolean("isLoggedIn", false)
        setContentView(R.layout.activity_login)

        // if isLoggedIn is false then store the data in isLoggedIn
        if(isLoggedIn)
        {
           val intent = Intent(this@LoginActivity, ContactAvengersActivity::class.java)
            startActivity(intent)
            finish()
        }

        btnlogin = findViewById(R.id.btnlogin)
        txt_forget_pass = findViewById(R.id.txt_Forget_pass)
        et_mobilenumber = findViewById(R.id.et_mobile_number)
        et_password = findViewById(R.id.et_password)

        btnlogin.setOnClickListener {

        val mobilenumber = et_mobilenumber.text.toString()
        val password = et_password.text.toString()
        var NameofAvenger = "The Avengers"


    /*
        if((mobilenumber == validMobileNumber) && (password == validMobilePass))
        {

            startActivity(intent)
        }
        else
        {
            Toast.makeText(this@LoginActivity, "Incorrect Credentials ! ", Toast.LENGTH_LONG).show()
        }
         */

        if(mobilenumber == validMobileNumber)
        {
            if(password == validMobilePass[0])
            {
                savePreference()
                NameofAvenger = "Iron Man"
                startActivity(intent)
            }
            else if (password == validMobilePass[1])
            {
                savePreference()
                NameofAvenger = "Thor"
                startActivity(intent)
            }
            else if(password == validMobilePass[2])
            {
                savePreference()
                NameofAvenger = "Hulk !!"
                startActivity(intent)
            }
            else if(password == validMobilePass[3])
            {
                savePreference()
                NameofAvenger= "All the remaining Members"
                startActivity(intent)
            }
        }
        else
        {
            Toast.makeText(this@LoginActivity, "incorrect Credentials !!", Toast.LENGTH_LONG).show()
        }

    }


    }
    // for pause the activity once we login
    override fun onPause()
    {
        super.onPause()
        finish()
    }

    fun savePreference()
    {
        sharedprefernced.edit().putBoolean("isLoggedIn", true).apply()
    }

}