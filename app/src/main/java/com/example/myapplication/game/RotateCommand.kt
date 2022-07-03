package com.example.myapplication.game

class RotateCommand(val r: Rotable) : Command{

    override fun execute(){
        r.setDirection(
            (r.getDirection() + r.getAngularVelocity()) % r.getDirectionsNumber()
        )
    }
}