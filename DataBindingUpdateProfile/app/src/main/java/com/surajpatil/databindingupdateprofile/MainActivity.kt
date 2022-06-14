package com.surajpatil.databindingupdateprofile

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.surajpatil.databindingupdateprofile.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.btnUpdate.setOnClickListener{
            UpdateName(it)
        }
    }

    private fun UpdateName(view:View)
    {
        binding.apply {
            txtName.text = binding.etName.text
            txtName.visibility = View.VISIBLE

            txtEmail.text = binding.etEmail.text
            txtEmail.visibility = View.VISIBLE

            txtNumber.text = binding.etNumber.text
            txtNumber.visibility = View.VISIBLE
        }

        val hide = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        hide.hideSoftInputFromWindow(view.windowToken, 0)
    }
}