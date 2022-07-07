package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)

        rollButton.setOnClickListener {

            rollDice()
        }
    }
//the function that run the roll
    private fun rollDice() {
        //create new Dice object
        val dice = Dice(6)
        val diceRoll = dice.roll()
    val diceImage : ImageView = findViewById(R.id.imageView)
        val drawableResource =  when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
           else -> R.drawable.dice_6

        }

    diceImage.setImageResource(drawableResource)
    diceImage.contentDescription = diceRoll.toString()

    }
}
//creating new class to store the dice info
class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}