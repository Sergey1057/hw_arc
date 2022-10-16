package com.example.myapplication.game.ThreadStrategyTest

import com.example.myapplication.game.Command
import com.example.myapplication.game.IoC.IoC
import com.example.myapplication.game.ThreadStrategy.GameCommand
import junit.framework.Assert
import org.junit.Test
import org.mockito.Mockito
import java.util.*


class ThreadStrategyTest {

    private var command : Command = Mockito.mock(Command::class.java)
    private var command2 : Command = Mockito.mock(Command::class.java)
    private var command3 : Command = Mockito.mock(Command::class.java)

    private val gameCommand = GameCommand()

    @Test
    fun gameCommandTest() {
        gameCommand.execute()
       val queue =  IoC.resolve<Queue<Command>>("Queue")
        queue.add(command)
        queue.add(command2)
        queue.add(command3)
        Assert.assertTrue(gameCommand.thread?.state == Thread.State.RUNNABLE)
    }
}

