package xyz.crafttogether.brucke.discord

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import xyz.crafttogether.brucke.Source
import xyz.crafttogether.brucke.configuration.ConfigHandler
import xyz.crafttogether.brucke.utils.Webhook
import xyz.crafttogether.kelp.Kelp
import java.io.IOException

object DiscordSender {

    private val logger: Logger = LoggerFactory.getLogger(DiscordSender::class.java)

    fun sendMessage(username: String, message: String, avatar: String, source: Source) {
        if (!Kelp.isConnected()) return

        val args = message.split("\\s+").toMutableList()
        args.forEachIndexed { i, arg ->
            if (arg == "@here" || arg == "@everyone") args[i] = ""
        }
        val parsedMessage = args.joinToString(separator = " ")
        if (message.isEmpty()) return

        try {
            Webhook(ConfigHandler.config.discordWebhook)
                .setAvatarUrl(avatar)
                .setUsername(username)
                .setContent(String.format("%s %s", source.prefix, parsedMessage))
                .send()
        } catch (e: IOException) {
            logger.error("Failed to send discord message")
            e.printStackTrace()
        }
    }

}