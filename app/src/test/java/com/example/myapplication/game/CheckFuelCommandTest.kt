package com.example.myapplication.game

import org.junit.Assert
import org.junit.Test
import org.mockito.Mockito

class CheckFuelCommandTest {

    private var fuelable: Fuelable = Mockito.mock(Fuelable::class.java)
    private var checkFuelCommand: CheckFuelCommand = CheckFuelCommand(fuelable)

    // Проверка, что выбрасывается исключение если скорость расхода топлива превышает его запас
    @Test
    fun testCheckFuelException() {
        Mockito.`when`(fuelable.getFuelAmount()).thenReturn(5)
        Mockito.`when`(fuelable.getFuelBurnSpeed()).thenReturn(6)
        Assert.assertThrows(CommandException::class.java) { checkFuelCommand.execute() }
    }

}