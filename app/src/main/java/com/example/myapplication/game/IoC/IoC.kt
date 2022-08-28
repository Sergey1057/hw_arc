package com.example.myapplication.game.IoC

import com.example.myapplication.game.Command
import java.lang.IllegalStateException


class IoC {
    companion object {

        private var scopes = ThreadLocal<Scope>()

        fun <T> resolve(key: String, vararg args: Any): T {
            return when (key) {
                "Scopes.New" -> NewScopeCommand(
                    args[0] as String
                ) as T
                "Scopes.Current" -> CurrentScopeCommand(
                    args[0] as String
                ) as T
                "IoC.Register" -> RegistryCommand(args[0] as String, args[1] as (Array<Any>) -> Any) as T
                else -> {
                    val strategy = scopes.get().strategies[key]
                    return if (strategy != null) {
                        return strategy.invoke(args as Array<Any>) as T
                    } else {
                        throw IllegalArgumentException("Can't resolve dependency: $key")
                    }
                }
            }
        }

        fun createScope(id: String): Scope {
            return ScopeImpl(id)
        }

        class NewScopeCommand(
            private val key: String,
            override var type: Int = 101
        ) : Command {
            override fun execute() {
                val newScope = createScope(key)
                scopes.set(newScope)
            }
        }

        class CurrentScopeCommand(
            private val key: String,
            override var type: Int = 102
        ) : Command {
            override fun execute() {
                val currentScope = scopes.get()
                if (currentScope == null) {
                    throw IllegalStateException("scope is not set")
                }
            }
        }

        class RegistryCommand(
            private val key: String,
            private val strategy: (Array<Any>) -> Any,
            override var type: Int = 100
        ) : Command {
            override fun execute() {
                scopes.get().strategies[key] = strategy
            }
        }
    }
}