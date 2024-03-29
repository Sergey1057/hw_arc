package com.example.myapplication.game

import java.lang.Exception

open class MacroCommand (val commands: Array<Command>): Command {
    override var type: Int = 6

    override fun execute() {

        try {
            commands.forEach {
                it.execute()
            }
        } catch (e: Exception){
            throw CommandException(e.localizedMessage)
        }

    }
}