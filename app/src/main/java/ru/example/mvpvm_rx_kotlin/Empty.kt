package ru.example.mvpvm_rx_kotlin

/**
* Created by Aleksei Guskov on 29.08.2017.
*/
class Empty private constructor() {
    companion object {
        val instance = Empty()
    }
}