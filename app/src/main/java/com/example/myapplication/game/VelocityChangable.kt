package com.example.myapplication.game

interface VelocityChangable {

    fun getVelocity() : Vector
    fun getAngle(): Int
    fun setVelocity(newV: Vector)

}