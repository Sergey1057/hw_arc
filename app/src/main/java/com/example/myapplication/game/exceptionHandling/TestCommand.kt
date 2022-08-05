package com.example.myapplication.game.exceptionHandling

import com.example.myapplication.game.Command
import java.lang.RuntimeException

class TestCommand : Command {
    override var type: Int = 8

    override fun execute() {
       throw RuntimeException()
    }
}