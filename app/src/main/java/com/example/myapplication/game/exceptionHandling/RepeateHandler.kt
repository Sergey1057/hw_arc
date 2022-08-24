package com.example.myapplication.game.exceptionHandling

import com.example.myapplication.game.Command
import java.util.*

class RepeateHandler(private val queue: Queue<Command>) : ExceptionHandler {
    override fun handle(command: Command, exception: Exception) {
        val repeateCommand = RepeateCommand(command)
        queue.add(repeateCommand)
    }
}