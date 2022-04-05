package com.example.dicerollerimage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener{rollDice()}
    }

    private fun rollDice()
    {
        val randomInt = (1..6).random()
        val diceImage: ImageView = findViewById(R.id.dice_image)

        val editText: EditText = findViewById(R.id.editNumber)


        val drawableResource = when (randomInt){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage.setImageResource(drawableResource)

        //val resultText: TextView = findViewById(R.id.resultText)
        //resultText.text = randomInt.toString()

        //Toast.makeText(this, resultText.text, Toast.LENGTH_SHORT).show()

        if (editText.length() != 0)
        {
            if (randomInt == Integer.parseInt(editText.text.toString()))
            {
                Toast.makeText(this, "Você Ganhou", Toast.LENGTH_SHORT).show()
            }
            else
            {
                Toast.makeText(this, "Você Perdeu", Toast.LENGTH_SHORT).show()
            }
        }
        else
        {
            Toast.makeText(this, "Informe seu número da sorte", Toast.LENGTH_SHORT).show()
        }

    }
}