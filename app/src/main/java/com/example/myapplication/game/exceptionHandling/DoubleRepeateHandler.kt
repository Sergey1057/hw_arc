package com.example.myapplication.game.exceptionHandling

import com.example.myapplication.game.Command
import java.util.*

class DoubleRepeateHandler(private val queue: Queue<Command>) : ExceptionHandler {
    override fun handle(command: Command, exception: Exception) {
        val doubleRepeateCommand = DoubleRepeateCommand(command)
        queue.add(doubleRepeateCommand)
    }
}