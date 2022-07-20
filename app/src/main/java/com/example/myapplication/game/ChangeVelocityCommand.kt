package com.example.myapplication.game

class ChangeVelocityCommand (val velocityChangable: VelocityChangable) : Command{

    override fun execute() {
        val k = Math.toRadians(velocityChangable.getAngle().toDouble())
        val x2 = Math.round((velocityChangable.getVelocity().x) * Math.cos(k) + (velocityChangable.getVelocity().y) * Math.sin(k))
        val y2 = Math.round(-(velocityChangable.getVelocity().x) * Math.sin(k) + (velocityChangable.getVelocity().y) * Math.cos(k))
        velocityChangable.setVelocity(Vector(x2.toInt(), y2.toInt()))
    }
}