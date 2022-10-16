package com.example.myapplication.game.ThreadStrategy

import com.example.myapplication.component1
import com.example.myapplication.game.Command
import com.example.myapplication.game.IoC.IoC
import com.example.myapplication.game.exceptionHandling.LogExceptionHandler
import java.util.*
import java.util.concurrent.ConcurrentLinkedQueue

class GameCommand: Command {
    override var type: Int = 115
    val queue : Queue<Command> = ConcurrentLinkedQueue()
    var thread: Thread? = null

    init {
        IoC.resolve<Command>("Scopes.New", "scopeId").execute()
        IoC.resolve<Command>("Scopes.New", "scopeId").execute()
        IoC.resolve<Command>(
            "IoC.Register",
            "Queue",
            { (_): Any -> queue }
        ).execute()
        IoC.resolve<Command>(
            "IoC.Register",
            "LogExceptionHandler",
            { (_): Any -> LogExceptionHandler(queue) }
        ).execute()
    }

    override fun execute() {
        thread = Thread(ThreadStrategy(queue))
        thread?.start()
    }
}