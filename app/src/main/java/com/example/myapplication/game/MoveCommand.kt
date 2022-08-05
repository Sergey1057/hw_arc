package com.example.myapplication.game

class MoveCommand (val m: Movable) : Command {
    override var type: Int = 7

    override fun execute(){
        m.setPosition(
            Vector.plus(
                m.getPosition(),
                m.getVelocity()
            )
        )
    }
}