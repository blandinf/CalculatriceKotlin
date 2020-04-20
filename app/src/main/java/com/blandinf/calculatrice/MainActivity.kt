package com.blandinf.calculatrice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    lateinit var screenInput: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        screenInput = findViewById(R.id.screen)
    }

    fun digitClicked(view: View) {
        val value = (view as Button).text.toString()
        CalculLogic.addValue(value.toDouble())
        screenInput.append(value)
    }

    fun operatorClicked(view: View) {
        val op = (view as Button).text.toString()
        val lastChar: Double? = screenInput.text.takeLast(1).toString().toDoubleOrNull()
        if (lastChar is Number) {
            CalculLogic.operator = op
            screenInput.append(op)
        }
    }

    fun clearScreen(view: View) {
        screenInput.text = ""
        CalculLogic.clear()
    }

    fun result(view: View) {
        try {
            var result = CalculLogic.compute()
            screenInput.text = result.toString()
        } catch (e: Exception) {
            screenInput.error = e.toString()
        }
    }
}
