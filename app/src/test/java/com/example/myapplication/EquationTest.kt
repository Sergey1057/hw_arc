package com.example.myapplication

import org.junit.Assert.assertArrayEquals
import org.junit.Test

class EquationTest {

    //Написать тест, который проверяет,
    // что для уравнения x^2+1 = 0 корней нет (возвращается пустой массив)
    @Test
    fun testSimple() {
        val eq = Equation()
        assertArrayEquals(
            null,
            emptyArray(),
            eq.solve(1.0, 0.0, 1.0),
        )
    }
}