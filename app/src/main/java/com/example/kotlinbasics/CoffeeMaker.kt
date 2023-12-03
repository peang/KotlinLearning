package com.example.kotlinbasics

import kotlinx.coroutines.delay

suspend fun main() {
    println("What drinks do you want ?")
    println("1. Coffee")
    println("2. Tea")
    println("3. Water")
    val type = readln().toInt()

    println("How many cups do you want ?")
    val cup = readln().toInt()

    val maker = Maker(type, cup)
    maker.create()
}

open class Maker(private val type: Int = 3, var cup: Int) {
    private var machine: Maker? = null

    open suspend fun create() {
        machine = when(type) {
            1 -> CoffeeMaker(cup)
            2 -> TeaMaker(cup)
            else -> null
        }

        if (machine == null) {
            do {
                pouringWater()
                println()
                cup -= 1
            } while (cup > 0)
        } else {
            machine!!.create()
        }
    }

    fun pouringWater(){
        println("Pouring Water for Cup Number $cup ...")
    }

    fun pouringSugar(){
        println("Pouring Sugar for Cup Number $cup ...")
    }
}

class CoffeeMaker(cup: Int): Maker(1, cup) {
    override suspend fun create() {
        do {
            pouringWater()
            pouringCoffee()
            pouringSugar()
            println()
            cup -= 1
        } while (cup > 0)
    }

    private fun pouringCoffee(){
        println("Pouring Coffee for Cup Number $cup ...")
    }
}

class TeaMaker(cup: Int): Maker(2, cup) {
    override suspend fun create() {
        do {
            pouringWater()
            pouringTea()
            pouringSugar()
            println()
            cup -= 1
            delay(500)
        } while (cup > 0)
    }

    private fun pouringTea(){
        println("Pouring Tea for Cup Number $cup ...")
    }
}

