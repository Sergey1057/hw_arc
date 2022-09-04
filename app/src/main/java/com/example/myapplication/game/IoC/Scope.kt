package com.example.myapplication.game.IoC

interface Scope {

    var strategies: HashMap<String, (Array<Any>) -> Any>

    fun get(key: String): (Array<Any>) -> Any

}