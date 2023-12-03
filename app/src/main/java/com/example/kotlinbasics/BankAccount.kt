package com.example.kotlinbasics

class BankAccount(
    private var account: String,
    private var balance: Double
) {
    private var transactionHistory = mutableListOf<String>()

    fun deposit(amount: Double) {
        this.balance += amount;
        this.transactionHistory.add("Deposit of $amount")
    }

    fun withdraw(amount: Double) {
        if (this.balance - amount < 0) {
            throw Exception("Negative Balance")
        }

        this.balance -= amount
        this.transactionHistory.add("Withdraw of $amount")
    }

    fun getTransactionHistory(): Collection<String> {
        return this.transactionHistory
    }

    fun getBalance(): Double {
        return this.balance
    }
}