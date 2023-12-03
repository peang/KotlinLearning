package com.example.kotlinbasics

import kotlin.system.exitProcess

fun main() {
    val options: Map<Int, String> = mapOf(
        1 to "Rock",
        2 to "Paper",
        3 to "Scissor"
    )

    var maxRetry = 3
    var userInput: Int
    do {
        println("Please Pick Your Choies :")
        println("1 for ${options[1]}")
        println("2 for ${options[2]}")
        println("3 for ${options[3]}")
        userInput = readln().toInt()

        if (userInput !in options.keys) {
            if (maxRetry == 0) {
                println("Bodoh emang.")
                exitProcess(0)
            } else {
                println("Please provide valid Choices.")
                println("Try $maxRetry More.")
                maxRetry -= 1
            }
        }
    } while (userInput !in options.keys)
    val userInputStr = options[userInput]

    val computerInput: Int = options.keys.random()
    val computerInputStr = options[computerInput]

    println("User Choose $userInputStr")
    println("Computer Choose $computerInputStr")

    val winner: String
    when(userInputStr) {
        options[1] -> {
            winner = when(computerInputStr) {
                options[1] -> "Tie"
                options[2] -> "Computer"
                options[3] -> "User"
                else -> "Error"
            }
        }
        options[2] -> {
            winner = when(computerInputStr) {
                options[1] -> "User"
                options[2] -> "Tie"
                options[3] -> "Computer"
                else -> "Error"
            }
        }
        options[3] -> {
            winner = when(computerInputStr) {
                options[1] -> "Computer"
                options[2] -> "User"
                options[3] -> "Tie"
                else -> "Error"
            }
        }
        else -> winner = "Error"
    }

    println("So the winner is $winner")
}