package com.example.checkpoint

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var radioGroup: RadioGroup
    private lateinit var radioMale: RadioButton
    private lateinit var radioFemale: RadioButton
    private lateinit var editTextHeight: EditText
    private lateinit var buttonCalculate: Button

     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        radioGroup = findViewById(R.id.radioGroup)
        radioMale = findViewById(R.id.radioMale)
        radioFemale = findViewById(R.id.radioFemale)
        editTextHeight = findViewById(R.id.editTextHeight)
        buttonCalculate = findViewById(R.id.buttonCalculate)

        buttonCalculate.setOnClickListener {
            val heightText = editTextHeight.text.toString()
            if (heightText.isNotEmpty()) {
                val height = heightText.toDouble()
                val weight = if (radioGroup.checkedRadioButtonId == R.id.radioMale) {
                    (72.7 * height) - 58
                } else {
                    (62.1 * height) - 44.7
                }
                val message = "Peso ideal: %.2f kg".format(weight)
                Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(applicationContext, "Informe a altura", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
