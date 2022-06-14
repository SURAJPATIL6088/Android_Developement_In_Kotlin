package com.surajpatil.saveprofile

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.surajpatil.saveprofile.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = DataBindingUtil.setContentView(this , R.layout.activity_main)

        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        binding.btnUpdate.setOnClickListener {
            UpdateName(it)
        }
    }

    fun UpdateName(view: View) {

        binding.apply {

            // update the text into textView from EditText
            txtNickName.text = binding.editNickName.text
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