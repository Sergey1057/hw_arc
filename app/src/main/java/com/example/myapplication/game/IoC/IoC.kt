package com.example.myapplication.game.IoC

import com.example.myapplication.game.Adapters.UObject
import com.example.myapplication.game.Command
import com.example.myapplication.game.Vector
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy


class IoC {
    companion object {

        private var scopes = ThreadLocal<Scope>()
        lateinit var proxy : Any

        fun <T> resolve(key: String, vararg args: Any): T {
            return when (key) {
                "Scopes.New" -> NewScopeCommand(
                    args[0] as String
                ) as T
                "Scopes.Current" -> CurrentScopeCommand(
                    args[0] as String
                ) as T
                "Adapter" -> GeneratedAdapterCommand(
                    args[0] as Class<Any>,
                    args[1] as UObject,
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

        class GeneratedAdapterCommand(
            private val adapterInterface: Class<Any>,
            private val uObject: UObject,
            override var type: Int = 109
        ) : Command {
            override fun execute() {
                proxy = Proxy.newProxyInstance(adapterInterface.getClassLoader(),
                    arrayOf(adapterInterface),
                    IoCInvocationHandler(adapterInterface, uObject));
            }
        }

         class IoCInvocationHandler (val adapterInterface: Class<Any>, val uObject: UObject): InvocationHandler {
             override fun invoke(p0: Any?, method: Method?, p2: Array<out Any>?): Any? {
                 val iocName : String =
                     adapterInterface.name + "." + method?.name
                 if (method?.name!!?.startsWith("get")) {
                     return resolve<Vector>(iocName, uObject)
                 }
                 if (method?.name.startsWith("set")) {
                     resolve<Unit>(iocName, uObject, p2?.get(0) as Vector)
                 }
                return null
             }
         }
    }
}