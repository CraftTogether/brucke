package xyz.crafttogether.brucke.discord

import net.dv8tion.jda.api.events.ReadyEvent
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import xyz.crafttogether.brucke.configuration.ConfigHandler

class DiscordEventListener : ListenerAdapter() {
    companion object {
        private val logger: Logger = LoggerFactory.getLogger(DiscordEventListener::class.java)
    }
    private val channelId = ConfigHandler.config.discordChannelId

    override fun onMessageReceived(event: MessageReceivedEvent) {
        logger.info("Hello there --> it invoked")
        if (event.channel.idLong == channelId) {
            println(event.message.contentRaw)
        }
    }

    override fun onReady(event: ReadyEvent) {
        logger.info("READYYYYYYYYYYYYYY")
    }
}