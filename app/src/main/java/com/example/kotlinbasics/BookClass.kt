package com.example.kotlinbasics

fun main() {
    val myBook = BookData()

    println(myBook.title)

    val customBook = BookData("Being a Programmer", "Irvan", "2023")

    println(customBook.toString())
}

data class BookData(
    var title: String = "Unknown",
    var author: String = "Unknown",
    var yearPublished: String = "Unknown"
)