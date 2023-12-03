package com.example.kotlinbasics

import kotlin.system.exitProcess

fun main() {
    val irvanBankAccount = BankAccount("Irvan", 0.0)

    try {
        irvanBankAccount.deposit(100.0)
        irvanBankAccount.withdraw(10.0)
        irvanBankAccount.deposit(20.0)
        irvanBankAccount.withdraw(90.0)
    } catch (e: Exception) {
        print(e.message)
        exitProcess(0)
    }

    println(irvanBankAccount.getTransactionHistory())
    println(irvanBankAccount.getBalance())
}