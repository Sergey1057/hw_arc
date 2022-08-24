package com.example.myapplication.game.exceptionHandling

import com.example.myapplication.game.Command

class LogCommand (
    private val innerCommand: Command,
    private val exception: Exception
    ): Command {

    override var type: Int = 1

    override fun execute() {
        println("$innerCommand ${exception.localizedMessage}")
    }
}