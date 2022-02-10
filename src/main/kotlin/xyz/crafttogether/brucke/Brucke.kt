package xyz.crafttogether.brucke

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.plugin.java.JavaPlugin
import xyz.crafttogether.brucke.discord.DiscordEventListener
import xyz.crafttogether.kelp.Kelp

class Brucke : JavaPlugin() {

    override fun onEnable() {
        plugin = this
        Kelp.addListeners(DiscordEventListener())
        Bukkit.getConsoleSender().sendMessage(String.format("%sBrucke enabled", ChatColor.GREEN))
    }

    override fun onDisable() {
        Bukkit.getConsoleSender().sendMessage(String.format("%sBrucke disabled", ChatColor.RED))
    }

    companion object {
        lateinit var plugin: JavaPlugin
    }
}
