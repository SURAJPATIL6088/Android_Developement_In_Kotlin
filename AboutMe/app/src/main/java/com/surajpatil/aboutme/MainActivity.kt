package com.surajpatil.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.surajpatil.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val myName :MyName = MyName("Suraj Patil")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this , R.layout.activity_main)

        binding.myName = myName

        binding.btnUpdate.setOnClickListener {
            // passing function
            UpdateName(it)
        }
    }

    private fun UpdateName(view: View) {

        binding.apply {

            // update the text into textView from EditText
            //txtNickName.text = binding.editNickName.text
            myName?.nickname = editNickName.text.toString()
            invalidateAll()

            // after entering the name keyboard will close
            editNickName.visibility = View.GONE

            // after click on the button button will be gone
            btnUpdate.visibility = View.GONE

            // it shows the the textView
            txtNickName.visibility = View.VISIBLE
        }

        val hide = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        hide.hideSoftInputFromWindow(view.windowToken , 0)
    }
}