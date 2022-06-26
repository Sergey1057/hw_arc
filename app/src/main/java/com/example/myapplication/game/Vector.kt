package com.example.myapplication.game

class Vector(val x: Int, val y: Int) {

    companion object {
        fun plus( position: Vector, velocity :Vector):Vector{
            return Vector(position.x + velocity.x, position.y + velocity.y)
        }
    }
}

