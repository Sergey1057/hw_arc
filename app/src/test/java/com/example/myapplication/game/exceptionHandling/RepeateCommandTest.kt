package com.example.myapplication.game.exceptionHandling

import com.example.myapplication.game.Command
import org.junit.Test
import org.mockito.Mockito

class RepeateCommandTest {

    private var innerCommand: Command = Mockito.mock(Command::class.java)
    private var repeateCommand: RepeateCommand = RepeateCommand(innerCommand)

    @Test
    fun testLogCommand() {
        repeateCommand.execute()
        Mockito.verify(innerCommand, Mockito.times(1)).execute()
    }
}