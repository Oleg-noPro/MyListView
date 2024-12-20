package com.example.mylistview

data class User(val name: String, val age: Int) {
    override fun toString(): String {
        return "Имя: $name, возраст: $age"
    }
}