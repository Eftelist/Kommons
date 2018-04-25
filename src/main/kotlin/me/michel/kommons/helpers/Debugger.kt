package me.michel.kommons.helpers

import org.bukkit.Bukkit

data class Debugger(var debug: Boolean) {

    //TODO: info functies etc
    fun debug(message: String) {
        if (debug) {
            // TODO: Make better..
            Bukkit.broadcast(message, "Kommons.debug")
        }
    }

}