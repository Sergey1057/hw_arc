package com.example.myapplication.game

class BurnFuelCommand (val fuelable: Fuelable) : Command {
    override var type: Int = 3

    override fun execute() {
       fuelable.burn()
    }
}