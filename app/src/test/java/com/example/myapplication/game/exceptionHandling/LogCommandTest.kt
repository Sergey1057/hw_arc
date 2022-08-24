package com.example.myapplication.game.exceptionHandling

import com.example.myapplication.game.Command
import org.junit.Test
import org.mockito.Mockito
import java.lang.Exception

class LogCommandTest {

    private var cmd: Command = Mockito.mock(Command::class.java)
    private var ex: Exception = Mockito.mock(Exception::class.java)
    private var logCommand: LogCommand = LogCommand(cmd, ex)

    @Test
    fun testLogCommand() {
        logCommand.execute()
        Mockito.verify(ex, Mockito.times(1)).localizedMessage
    }
}