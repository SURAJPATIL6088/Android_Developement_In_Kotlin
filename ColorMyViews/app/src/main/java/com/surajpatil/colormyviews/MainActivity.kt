package com.surajpatil.colormyviews

import android.graphics.Color
import android.graphics.Color.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setListeners()
    }

    private fun setListeners(){

        val clickableViews : List<View> = listOf(txtBox1, txtBox2, txtBox3, txtBox4, txtBox5)

        for(item in clickableViews){
            item.setOnClickListener(this::makeColored)
        }
    }

    private fun makeColored(view: View){

        when(view.id){
            R.id.txtBox1 -> view.setBackgroundColor(DKGRAY)
            R.id.txtBox2 -> view.setBackgroundColor(GRAY)

            R.id.txtBox3 -> view.setBackgroundResource(android.R.color.holo_green_dark)
            R.id.txtBox4 -> view.setBackgroundResource(android.R.color.holo_green_light)
            R.id.txtBox5 -> view.setBackgroundResource(android.R.color.holo_orange_dark)

            else -> view.setBackgroundColor(LTGRAY)
        }
    }
}