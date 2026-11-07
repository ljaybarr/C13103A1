package com.example.c13103a1

// Challenge 1 Session 1
data class BakeryItem (
    val name: String,
    val sold: Double,
    val price: Double
) {
    // Challenge 2 Session 1
    fun revenue(): Double {
        return sold * price
    }
}