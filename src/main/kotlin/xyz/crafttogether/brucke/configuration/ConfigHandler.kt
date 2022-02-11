package xyz.crafttogether.brucke.configuration

import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.configuration.file.YamlConfiguration
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import xyz.crafttogether.brucke.Brucke
import java.io.File

object ConfigHandler {

    private val logger: Logger = LoggerFactory.getLogger(ConfigHandler::class.java)
    lateinit var config: Config
    private var file: File? = null

    fun loadConfig() {
        file = File(Brucke.plugin.dataFolder.path + "/config.yml")
        reloadConfig()
    }

    fun reloadConfig() {
        if (file == null) {
            logger.error("Config was not loaded before trying to reload")
            loadConfig()
            return
        }
        val configuration: FileConfiguration = YamlConfiguration.loadConfiguration(file!!)
        config = Config(
            configuration.getLong("discordGuildId"),
            configuration.getLong("discordChannelId"),
            configuration.getString("discordWebhook"),
            configuration.getString("discordPrefix"),
            configuration.getString("ircPrefix"),
            configuration.getString("minecraftPrefix")
        )
    }

}