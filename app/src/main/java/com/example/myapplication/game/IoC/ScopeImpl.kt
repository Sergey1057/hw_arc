package com.example.myapplication.game.IoC

class ScopeImpl (val id: String): Scope{

    override var strategies: HashMap<String, (Array<Any>) -> Any> = hashMapOf()

    override fun get(key: String): (Array<Any>) -> Any {
        return strategies[key]!!
    }
}