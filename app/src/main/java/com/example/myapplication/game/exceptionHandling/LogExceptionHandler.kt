package com.example.myapplication.game.exceptionHandling

import com.example.myapplication.game.Command
import java.util.*

class LogExceptionHandler(private val queue: Queue<Command>) : ExceptionHandler {
    override fun handle(command: Command, exception: Exception) {
        val logCommand = LogCommand(command, exception)
        queue.add(logCommand)
    }
}