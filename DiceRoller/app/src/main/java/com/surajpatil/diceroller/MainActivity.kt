package com.surajpatil.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var btn_roll:Button
    lateinit var img_dice:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_roll = findViewById(R.id.btn_roll)
        img_dice = findViewById(R.id.img_dice)

        btn_roll.setOnClickListener {
            Toast.makeText(this, "Roll Button Clicked !!", Toast.LENGTH_SHORT).show()
            DiceRoll()
        }
    }

    private fun DiceRoll() {
        val ran_number = java.util.Random().nextInt(6)+1

        val store = when(ran_number)
        {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        img_dice.setImageResource(store)
    }
}
