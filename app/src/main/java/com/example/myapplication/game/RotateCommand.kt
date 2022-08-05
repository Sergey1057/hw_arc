package com.example.myapplication.game

class RotateCommand(val r: Rotable) : Command{
    override var type: Int = 9

    override fun execute(){
        r.setDirection(
            (r.getDirection() + r.getAngularVelocity()) % r.getDirectionsNumber()
        )
    }
}