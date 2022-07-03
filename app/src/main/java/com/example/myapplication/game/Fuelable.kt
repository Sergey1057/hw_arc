package com.example.myapplication.game

interface Fuelable {

   fun getFuelAmount(): Int
   fun getFuelBurnSpeed(): Int
   fun burn()
}