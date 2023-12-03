package com.example.kotlinbasics

import kotlinx.coroutines.delay

fun main() {
    var shoppingList = mutableListOf<String>("Terigu", "Gula", "Mentega", "Meses")
    shoppingList.add("Oncom")

    var number = 0 .. 200

    for (idx in shoppingList.indices) {
        println(shoppingList[idx])
    }
}