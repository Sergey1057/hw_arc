package com.example.myapplication

import org.junit.Assert.assertArrayEquals
import org.junit.Test
import java.lang.IllegalArgumentException

class EquationTest {

    val eq = Equation()

    //Написать тест, который проверяет,
    // что для уравнения x^2+1 = 0 корней нет (возвращается пустой массив)
    @Test
    fun testPoint3() {
        assertArrayEquals(
            null,
            emptyArray(),
            eq.solve(1.0, 0.0, 1.0),
        )
    }

    // Написать тест, который проверяет, что для уравнения x^2-1 = 0
    // есть два корня кратности 1 (x1=1, x2=-1)
    @Test
    fun testPoint5() {
        val result = eq.solve(1.0, 0.0, -1.0)
        result.sort()
        assertArrayEquals(
            null,
            arrayOf(-1.0, 1.0),
            result,
        )
    }

    //Написать тест, который проверяет, что для уравнения x^2+2x+1 = 0
    // есть один корень кратности 2 (x1= x2 = -1).
    @Test
    fun testPoint7() {
        assertArrayEquals(
            null,
            arrayOf(-1.0),
            eq.solve(1.0, 2.0, 1.0),
        )
    }

    //Написать тест, который проверяет, что коэффициент a не может быть равен 0.
    // В этом случае solve выбрасывает исключение.
    // Примечание. Учесть, что a имеет тип double и сравнивать с 0 через == нельзя.
    // @Test(expected = IllegalArgumentException.class)
    @Test(expected = IllegalArgumentException::class)
        fun testPoint9() {
        assertArrayEquals(
            null,
            arrayOf(-1.0),
            eq.solve(0.0, 2.0, 1.0),
        )
    }

    //С учетом того, что дискриминант тоже нельзя сравнивать с 0 через знак равенства,
    // подобрать такие коэффициенты квадратного уравнения для случая одного корня кратности два,
    // чтобы дискриминант был отличный от нуля, но меньше заданного эпсилон.
    // Эти коэффициенты должны заменить коэффициенты в тесте из п. 7.
    @Test
    fun testPoint7_2() {
        assertArrayEquals(
            null,
            arrayOf(-1.00000000005),
            eq.solve(1.0, 2.0000000001, 1.0),
        )
    }

    //Посмотреть какие еще значения могут принимать числа типа double,
    // кроме числовых и написать тест с их использованием на все коэффициенты.
    // solve должен выбрасывать исключение.
    @Test(expected = IllegalArgumentException::class)
    fun testPoint13() {
        assertArrayEquals(
            null,
            arrayOf(-1.0),
            eq.solve(Double.NaN, 2.0, 1.0),
        )
    }

    @Test(expected = IllegalArgumentException::class)
    fun testPoint13_2() {
        assertArrayEquals(
            null,
            arrayOf(-1.0),
            eq.solve(Double.NEGATIVE_INFINITY, 2.0, 1.0),
        )
    }

    @Test(expected = IllegalArgumentException::class)
    fun testPoint13_3() {
        assertArrayEquals(
            null,
            arrayOf(-1.0),
            eq.solve(Double.POSITIVE_INFINITY, 2.0, 1.0),
        )
    }
}