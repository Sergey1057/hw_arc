package com.example.myapplication

class Equation() {
    private var a :Double = 0.0
    private var b :Double = 0.0
    private var c :Double = 0.0

    fun solve(a: Double, b: Double, c:Double): Array<Double> {
        this.a = a
        this.b = b
        this.c = c

        val discriminant = getDiscriminant()
        return if (discriminant > 0) {
                val x1 = (-b - Math.sqrt(discriminant)) / (2 * a)
                val x2 = (-b + Math.sqrt(discriminant)) / (2 * a)
            arrayOf(x1,x2)
            } else if (discriminant == 0.0 ) {
                val x = -b / (2 * a)
            arrayOf(x)
            } else { emptyArray()
        }
    }

    private fun isQuadratic(): Boolean {
        return a != 0.0
    }

    private fun isLinear(): Boolean {
        return a == 0.0 && b != 0.0 && c != 0.0
    }

    private fun getDiscriminant(): Double {
        return b * b - 4 * a * c
    }

    override fun toString(): String {
        return "$a*x^2 + $b*x + $c = 0"
    }
}