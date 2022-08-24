package com.example.myapplication.game.exceptionHandling

import com.example.myapplication.game.Command

interface ExceptionHandler {

        fun handle(command: Command, exception: Exception)
    }
