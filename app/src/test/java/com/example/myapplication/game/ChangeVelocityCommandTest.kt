package com.example.myapplication.game

import org.junit.Test
import org.mockito.Mockito

class ChangeVelocityCommandTest {

    private var velocityChangable: VelocityChangable = Mockito.mock(VelocityChangable::class.java)
    private var changeVelocityCommand: ChangeVelocityCommand = ChangeVelocityCommand(velocityChangable)

    // Для объекта, движущегося со скоростью (20,30) и
    // поворачивающегося на 90 новая скорость будет (30,-20)
    @Test
    fun testMove() {
        Mockito.`when`(velocityChangable.getVelocity()).thenReturn(Vector(20,30))
        Mockito.`when`(velocityChangable.getAngle()).thenReturn(90)
        changeVelocityCommand.execute()
        Mockito.verify(velocityChangable, Mockito.times(1)).setVelocity(Vector(30,-20))
    }

}