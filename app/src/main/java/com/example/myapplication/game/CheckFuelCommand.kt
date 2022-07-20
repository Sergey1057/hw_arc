package com.example.myapplication.game

class CheckFuelCommand (val fuelable: Fuelable): Command {

    override fun execute() {
        if (fuelable.getFuelAmount() < fuelable.getFuelBurnSpeed()) {
            throw CommandException("not enough fuel")
        }
    }
}