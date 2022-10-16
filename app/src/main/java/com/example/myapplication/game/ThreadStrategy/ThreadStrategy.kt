package com.example.myapplication.game.ThreadStrategy

import com.example.myapplication.game.Command
import com.example.myapplication.game.IoC.IoC
import com.example.myapplication.game.exceptionHandling.ExceptionHandler
import java.util.*


class ThreadStrategy(queue: Queue<Command>) : Runnable {

    companion object {
        lateinit var handler :()-> Unit
        lateinit var queue: Queue<Command>
        var stop: Boolean = false
    }

    init {
        ThreadStrategy.queue = queue
        handler   =
        {
            if (queue?.isNullOrEmpty()!!){
                val command = queue.poll()
                try {
                    command.execute()
                } catch(e: Exception){
                    IoC.resolve<ExceptionHandler>("LogExceptionHandler").handle(command,e)
                }
            }
        }
    }

    override fun run() {
        while (!stop) {
            handler()
        }

    }

    class SoftStopCommand : Command {
        override var type: Int =118
        override fun execute() {
            handler = {
                while (!queue.isEmpty()) {
                    val command = queue.poll()
                    try {
                        command.execute();
                    } catch ( e: Exception) {
                        IoC.resolve<ExceptionHandler>("LogExceptionHandler").handle(command,e)
                    }
                }
            stop = true;
        }
        }
    }

    class HardStopCommand : Command {
        override var type: Int = 119
        override fun execute() {
            stop = true
            Thread.currentThread().interrupt()
        }
    }
}