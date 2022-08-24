package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.game.Command
import com.example.myapplication.game.exceptionHandling.*
import java.lang.Exception
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var cmd: Command
    private var queue: Queue<Command> = LinkedList()
    private var handlers = mapOf(
        2 to LogExceptionHandler(queue),
        8 to RepeateHandler(queue),
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cmd = TestCommand()
        queue.add(cmd)
        while (!queue.isEmpty()){
            try {
                var cmdInQueue =  queue.poll()
                cmd = cmdInQueue
                cmdInQueue?.execute()
            } catch (ex: Exception){
                handle(cmd, ex)
            }
        }
    }

    fun handle(cmd: Command, ex: Exception){
        handlers[cmd.type]?.handle(cmd, ex)
    }
}