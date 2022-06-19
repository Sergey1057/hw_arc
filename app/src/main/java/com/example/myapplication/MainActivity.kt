package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val equation = Equation()
        val results = equation.solve(1.0, -13.0, 36.0)
        println("test10 ${results[0]} ${results[1]}")
    }
}