package com.example.myapplication.game

class MoveBurnFuelCommand(
    fuelable: Fuelable,
    movable: Movable
) : MacroCommand(
    arrayOf(
        CheckFuelCommand(fuelable),
        MoveCommand(movable),
        BurnFuelCommand(fuelable)
    )
)
