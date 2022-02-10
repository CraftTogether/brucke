package xyz.crafttogether.brucke

import xyz.crafttogether.brucke.configuration.ConfigHandler

enum class Source(val prefix: String?) {
    DISCORD(ConfigHandler.config.discordPrefix),
    IRC(ConfigHandler.config.ircPrefix),
    MINECRAFT(ConfigHandler.config.minecraftPrefix),
    OTHER(null)
}