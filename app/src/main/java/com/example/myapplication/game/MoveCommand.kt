package com.example.myapplication.game

class MoveCommand (val m: Movable) : Command {

    override fun execute(){
        m.setPosition(
            Vector.plus(
                m.getPosition(),
                m.getVelocity()
            )
        )
    }
}