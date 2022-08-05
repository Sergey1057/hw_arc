package com.example.myapplication.game.exceptionHandling

import com.example.myapplication.game.Command

class RepeateCommand (val innerCommand: Command): Command {

    override var type: Int = 2

    override fun execute() {
        innerCommand.execute()
    }
}