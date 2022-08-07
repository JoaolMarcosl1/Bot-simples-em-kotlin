import dev.kord.common.Color
import dev.kord.core.*
import dev.kord.core.behavior.interaction.respondPublic
import dev.kord.core.event.interaction.ChatInputCommandInteractionCreateEvent
import dev.kord.gateway.Intent
import dev.kord.gateway.PrivilegedIntent
import dev.kord.rest.builder.message.create.embed

suspend fun main(){
    val client =
        Kord("TOKEN")
    client.on<ChatInputCommandInteractionCreateEvent> {
        when(interaction.command.data.name.value){
            "ping" -> {
                interaction.respondPublic {
                    embed {
                        color = Color(18, 6, 191)
                        description = "Pong"
                        footer {
                            text = "Powered by Dogao"
                            icon = "https://cdn.discordapp.com/avatars/792887032615403550/333a9191c30ccdfef2995b22ae4660e6.png?size=128"
                        }
                    }
                }
            }
        }
    }

    @OptIn(PrivilegedIntent::class)
    client.login {
        intents += Intent.MessageContent
    }
}
