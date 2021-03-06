package xyz.crafttogether.brucke.configuration

data class Config(
    val discordGuildId: Long,
    val discordChannelId: Long,
    val discordWebhook: String?,
    val discordPrefix: String?,
    val ircPrefix: String?,
    val minecraftPrefix: String?
)