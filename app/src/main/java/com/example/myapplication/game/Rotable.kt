package com.example.myapplication.game

interface Rotable {
    fun getDirection(): Int
    fun getAngulatVelocity(): Int
    fun setDirection(newV: Int)
    fun getDirectionsNumber():Int
}