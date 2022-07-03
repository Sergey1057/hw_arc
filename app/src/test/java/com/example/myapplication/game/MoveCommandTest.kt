package com.example.myapplication.game

import junit.framework.TestCase
import org.junit.Assert.assertThrows
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import java.lang.RuntimeException


class MoveCommandTest : TestCase() {

    private var movable: Movable = Mockito.mock(Movable::class.java)
    private var moveCommand: MoveCommand = MoveCommand(movable)

    // Для объекта, находящегося в точке (12, 5) и
    // движущегося со скоростью (-7, 3) движение меняет положение объекта на (5, 8)
    @Test
    fun testMove() {
        `when`(movable.getPosition()).thenReturn(Vector(12,5))
        `when`(movable.getVelocity()).thenReturn(Vector(-7, 3))
        moveCommand.execute()
        Mockito.verify(movable, Mockito.times(1)).setPosition(Vector(5,8))
    }

   // Попытка сдвинуть объект, у которого невозможно прочитать положение в пространстве, приводит к ошибке
   @Test
   fun testExceptionPosition() {
       `when`(movable.getPosition()).thenThrow(RuntimeException())
       `when`(movable.getVelocity()).thenReturn(Vector(1, 1))
           assertThrows(RuntimeException::class.java) { moveCommand.execute() }
   }

    // Попытка сдвинуть объект, у которого невозможно прочитать положение в пространстве, приводит к ошибке
    @Test
    fun testExceptionVelocity() {
        `when`(movable.getPosition()).thenReturn(Vector(1, 1))
        `when`(movable.getVelocity()).thenThrow(RuntimeException())
        assertThrows(RuntimeException::class.java) { moveCommand.execute() }
    }

    // Попытка сдвинуть объект, у которого невозможно изменить положение в пространстве, приводит к ошибке
    @Test
    fun testExceptionSetPosition() {
        val vector = Vector(6,6)
        `when`(movable.getPosition()).thenReturn(Vector(1, 1))
        `when`(movable.getVelocity()).thenReturn(Vector(5, 5))
        `when`(movable.setPosition(vector)).thenThrow(RuntimeException())
        assertThrows(RuntimeException::class.java) { moveCommand.execute() }
    }
}