package com.example.myapplication.game.exceptionHandling

import com.example.myapplication.game.Command

class DoubleRepeateCommand (val innerCommand: Command): Command {

    override var type: Int = 3

    override fun execute() {
        innerCommand.execute()
    }
}