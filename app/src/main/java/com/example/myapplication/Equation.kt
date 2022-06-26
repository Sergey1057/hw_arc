package com.example.myapplication

import java.lang.IllegalArgumentException

class Equation {

    fun solve(a: Double, b: Double, c:Double, e:Double = 1e-5 ): Array<Double> {
        if (Math.abs(a) < e){
            throw IllegalArgumentException("a < e")
        }
        if (a.isNaN()
            || b.isNaN()
            || c.isNaN()
            || a.isInfinite()
            || b.isInfinite()
            || c.isInfinite()
        ){
            throw IllegalArgumentException("not number coefficient")
        }

        val discriminant = b * b - 4 * a * c
         if (discriminant > e) {
                val x1 = (-b - Math.sqrt(discriminant)) / (2 * a)
                val x2 = (-b + Math.sqrt(discriminant)) / (2 * a)
             return arrayOf(x1,x2)
            }
        if (Math.abs(discriminant) < e) {
                val x = -b / (2 * a)
            return arrayOf(x)
            } else {
            return emptyArray()
        }
    }
}