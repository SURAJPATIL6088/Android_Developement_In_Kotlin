package com.surajpatil.activitylifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
// we can see the what are the methods calling the Activity in the <Logcat> menu
    override fun onStart()
    {
        super.onStart()
        println("OnStart !!")
    }

    override fun onResume()
    {
        super.onResume()
        println("OnResume !!")
    }

    override fun onPause()
    {
        super.onPause()
        println("OnPause !!")
    }

    override fun onRestart()
    {
        super.onRestart()
        println("OnRestart !!")
    }

    override fun onStop()
    {
        super.onStop()
        println("OnStop !!")
    }
}