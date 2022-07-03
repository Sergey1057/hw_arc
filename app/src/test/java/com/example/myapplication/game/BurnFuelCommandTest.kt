package com.example.myapplication.game

import org.junit.Test
import org.mockito.Mockito

class BurnFuelCommandTest {

    private var fuelable: Fuelable = Mockito.mock(Fuelable::class.java)
    private var burnFuelCommand: BurnFuelCommand = BurnFuelCommand(fuelable)

    // Проверка, что вызывается метод сжигания топлива
    @Test
    fun testBurnFuel() {
        burnFuelCommand.execute()
        Mockito.verify(fuelable, Mockito.times(1)).burn()
    }

}