package com.example.myapplication.game.exceptionHandling

import com.example.myapplication.game.Command
import junit.framework.Assert.assertTrue
import org.junit.Test
import org.mockito.Mockito
import java.lang.Exception
import java.util.*

class RepeatHandlerTest {

    private var cmd: Command = Mockito.mock(Command::class.java)
    private var ex: Exception = Mockito.mock(Exception::class.java)
    private var queue: Queue<Command> = LinkedList()
    private var repeatHandler: RepeateHandler = RepeateHandler(queue)

    @Test
    fun testRepeatHandler() {
        repeatHandler.handle(cmd, ex)
        var cmdInQueue = queue.poll()
        assertTrue(cmdInQueue is RepeateCommand)
    }
}