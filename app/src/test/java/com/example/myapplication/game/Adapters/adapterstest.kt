package com.example.myapplication.game.Adapters

import com.example.myapplication.game.*
import com.example.myapplication.game.IoC.IoC
import com.example.myapplication.game.IoC.IoC.Companion.resolve
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.BDDMockito.given
import org.mockito.Mockito


class adapterstest {

    lateinit var uObject: UObject

    @Before
    internal fun setUp() {
        uObject = Mockito.mock(UObject::class.java)
        resolve<Command>("Scopes.New", "scopeId").execute()
        resolve<Command>("Adapter", Movable::class.java , uObject).execute()
    }

    @Test
    fun getPositionTest() {
        val testVector = Vector(5,7)
        given(uObject.getProperty("Position")).willReturn(testVector)
        val adapter = IoC.proxy as Movable
        resolve<Command>(
            "IoC.Register",
            "com.example.myapplication.game.Movable.getPosition",
            { args : Array<Any> ->
                val result:Vector = (args[0] as UObject).getProperty("Position") as Vector
                result
            }
        ).execute()
        Assert.assertEquals(
            null,
            adapter.getPosition(),
            testVector
        )
    }

    @Test
    fun getVelocityTest() {
        val testVector = Vector(7,9)
        given(uObject.getProperty("Velocity")).willReturn(testVector)
        val adapter = IoC.proxy as Movable
        resolve<Command>(
            "IoC.Register",
            "com.example.myapplication.game.Movable.getVelocity",
            { args : Array<Any> ->
                val obj = args
                val result:Vector = (obj[0] as UObject).getProperty("Velocity") as Vector
                result
            }
        ).execute()
        Assert.assertEquals(
            null,
            adapter.getVelocity(),
            testVector
        )
    }

    @Test
    fun setPositionTest() {
        val testVector = Vector(2,4)
        given(uObject.getProperty("Position")).willReturn(testVector)
        val adapter = IoC.proxy as Movable
        resolve<Command>(
            "IoC.Register",
            "com.example.myapplication.game.Movable.setPosition",
            { args : Array<Any> ->
                val obj = args
               (obj[0] as UObject).setProperty("Position", obj[1] as Vector)
            }
        ).execute()
        adapter.setPosition(testVector)
        Mockito.verify(uObject, Mockito.times(1)).setProperty("Position", testVector)
    }
}