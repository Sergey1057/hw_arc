package com.example.myapplication.game

class Move (val m: Movable) {

    fun execute(){
        m.setPosition(
            Vector.plus(
                m.getPosition(),
                m.getVelocity()
            )
        )
    }
}