package com.example.myapplication.game


interface Movable {
    fun getPosition() : Vector
    fun getVelocity() : Vector
    fun setPosition(newV: Vector)
}
