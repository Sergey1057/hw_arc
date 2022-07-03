package com.example.myapplication.game

class BurnFuelCommand (val fuelable: Fuelable) : Command {
    override fun execute() {
       fuelable.burn()
    }
}