package com.example.myapplication.game

interface Command {

    var type: Int

    fun execute()
}