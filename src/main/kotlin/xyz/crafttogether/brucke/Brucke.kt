package xyz.crafttogether.brucke

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.plugin.java.JavaPlugin

class Brucke : JavaPlugin() {

    override fun onEnable() {
        plugin = this
        Bukkit.getConsoleSender().sendMessage(String.format("%sBrucke enabled", ChatColor.GREEN))
    }

    override fun onDisable() {
        Bukkit.getConsoleSender().sendMessage(String.format("%sBrucke disabled", ChatColor.RED))
    }

    companion object {
        lateinit var plugin: JavaPlugin
    }
}
