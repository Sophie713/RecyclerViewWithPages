package com.example.recyclerviewwithpages.EventBus

/**
 * Created by Sophie on 2/25/2019.
 */
class PageEvent(message: Int) {
    private var message: Int

    init {
        this.message = message
    }

    fun getMessage(): Int {
        return message
    }
}