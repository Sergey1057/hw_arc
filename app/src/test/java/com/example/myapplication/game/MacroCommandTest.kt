package com.example.myapplication.game

import org.junit.Assert
import org.junit.Test
import org.mockito.Mockito


class MacroCommandTest {

    private var command : Command = Mockito.mock(Command::class.java)
    private var command2 : Command = Mockito.mock(Command::class.java)
    private var command3 : Command = Mockito.mock(Command::class.java)

    // если одна команда падает с исключением, то и макрокоманда падает
    @Test
    fun MacroCommandTestException() {
        Mockito.`when`(command2.execute()).thenThrow(CommandException("something went wrong"))
        val macroCommand = MacroCommand(arrayOf(command, command2, command3))
        Assert.assertThrows(CommandException::class.java) {macroCommand.execute()}
    }

    // у всех команд вызывается execute()
    @Test
    fun MacroCommandTest() {
        val macroCommand = MacroCommand(arrayOf(command, command2, command3))
        macroCommand.execute()
        Mockito.verify(command).execute()
        Mockito.verify(command2).execute()
        Mockito.verify(command3).execute()

    }
}