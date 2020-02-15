package mydomain.mybot

import com.jessecorbett.diskord.dsl.bot
import java.io.File


suspend fun main() {
    val token = File("token.txt").readText().trim()

    bot(token) {
        messageCreated {
            println("From: ${it.author.username}; ${it.content}")

            when {
                it.content.toLowerCase().startsWith("hi") ->
                    it.reply("Hello")

                it.content.toLowerCase().startsWith("Who") ->
                    it.reply("I am a bot")

                it.content == "ping" ->
                    it reply "pong"
            }
        }
    }
}
