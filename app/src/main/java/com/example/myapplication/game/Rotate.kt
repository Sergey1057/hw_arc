package com.example.myapplication.game

class Rotate(val r: Rotable) {

    fun execute(){
        r.setDirection(
            (r.getDirection() + r.getAngulatVelocity())%r.getDirectionsNumber()
        )
    }
}