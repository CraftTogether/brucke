package xyz.crafttogether.brucke.discord

import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

class DiscordEventListener : ListenerAdapter() {
    override fun onMessageReceived(event: MessageReceivedEvent) {
        println(event.message.contentRaw)
    }
}