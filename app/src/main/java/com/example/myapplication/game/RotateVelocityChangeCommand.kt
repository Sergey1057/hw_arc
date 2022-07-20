package com.example.myapplication.game

class RotateVelocityChangeCommand(
     r: Rotable,
     velocityChangable: VelocityChangable
) : MacroCommand(
    arrayOf(
        RotateCommand(r),
        ChangeVelocityCommand(velocityChangable)
    )
)
