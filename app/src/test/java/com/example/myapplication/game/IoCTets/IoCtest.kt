package com.example.myapplication.game.IoCTets

import com.example.myapplication.component1
import com.example.myapplication.game.*
import com.example.myapplication.game.IoC.IoC
import org.junit.Assert
import org.junit.Test


class IoCtest {

    @Test
    fun newScopeCommandTest() {
       val newscope =  IoC.resolve<Command>("Scopes.New", "scopeId")
        Assert.assertTrue(newscope is IoC.Companion.NewScopeCommand)
    }

    @Test
    fun currentScopeCommandTest() {
        val currentScope =  IoC.resolve<Command>("Scopes.Current", "scopeId")
        Assert.assertTrue(currentScope is IoC.Companion.CurrentScopeCommand)
    }

    @Test
    fun registerTest() {
        val regCommand = IoC.resolve<Command>(
            "IoC.Register",
            "MoveCommand",
            { (movable): Any -> MoveCommand(movable as Movable) }
        )
        Assert.assertTrue(regCommand is IoC.Companion.RegistryCommand)
    }
}