package com.example.myapplication.game

interface Rotable {
    fun getDirection(): Int
    fun getAngularVelocity(): Int
    fun setDirection(newV: Int)
    fun getDirectionsNumber():Int
}