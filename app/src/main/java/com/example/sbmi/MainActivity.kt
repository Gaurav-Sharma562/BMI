package com.example.sbmi


import android.os.Build.VERSION_CODES.R
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity




class MainActivity : AppCompatActivity() {
    private lateinit var calButton: Button
    private lateinit var etweight: EditText
    private lateinit var etheight: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weight = findViewById<EditText>(R.id.et_weight)
        val height = findViewById<EditText>(R.id.et_height)
        val calcButton = findViewById<Button>(R.id.Button)

        val info = findViewById<TextView>(R.id.TextView)


        calcButton.setOnClickListener {
            val weight = etweight.text.toString().toFloat()
            val height = etheight.text.toString().toFloat()
            val calButton = calButton.text.toString().toFloat()

            val bmi = weight.toFloat() / ((height.toFloat() / 100) * (height.toFloat() / 100))
            // get result
            val bmi2Digit = String.format("%.2f", bmi).toFloat()
            bmiResults(bmi2Digit)
            info.text = bmi2Digit.toString()
        }


    }



    private fun bmiResults(bmi: Float): String {
        lateinit  var answer: String
        if(bmi<18.5){
            "Underweight"
        } else if(bmi > 18.5 && bmi < 24.9) {
            "Normal"
        } else if(bmi > 24.9 && bmi < 30) {
            "Overweight"
        } else {
            "Obese"
        }
        return answer
    }

}


