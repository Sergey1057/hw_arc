package com.example.myapplication.game

import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class MoveBurnFuelCommandTest {

    private var fuelable: Fuelable = Mockito.mock(Fuelable::class.java)
    private var movable: Movable = Mockito.mock(Movable::class.java)

    @Before
    internal fun setUp() {
        Mockito.`when`(fuelable.getFuelAmount()).thenReturn(8)
        Mockito.`when`(fuelable.getFuelBurnSpeed()).thenReturn(5)
        Mockito.`when`(movable.getPosition()).thenReturn(Vector(10,2))
        Mockito.`when`(movable.getVelocity()).thenReturn(Vector(4, 5))
    }

    // Для объекта, находящегося в точке (10,2) и
    // движущегося со скоростью (-4, 5) движение меняет положение объекта на (14, 7)
    // и сжигается топливо
    @Test
    internal fun moveBurnFuelCommandTest() {
        val moveBurnFuelCommand = MoveBurnFuelCommand(fuelable, movable)
        moveBurnFuelCommand.execute()
        Mockito.verify(movable).setPosition(Vector(14, 7))
        Mockito.verify(fuelable).burn()
    }
}