package discordBot;

import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.channel.MessageChannel;
import discord4j.core.spec.EmbedCreateSpec;
import discord4j.rest.util.Color;

public class BotMessage {

    /**
     * Vigila los canales de Discord sobre los que tiene permiso para revisar si algún mensaje contiene un comando del programa
     *
     * @param gateway Una GatewayDiscordClient que contiene todos los datos necesarios para que el bot funcione
     */
    public static void sendMessage(GatewayDiscordClient gateway) {

        gateway.on(MessageCreateEvent.class).subscribe(event -> {

            final Message message = event.getMessage();

            if (message.getContent().startsWith("!")) {

                String[] comand = TriggerMethods.splitComand(message);

                final MessageChannel channel = message.getChannel().block();

                if (comand.length <= 2) {

                    Triggerable triggerable = TriggerMethods.getTrigger(comand[0]);

                    if (triggerable == null)
                        channel.createMessage(EmbedCreateSpec.builder()
                                .color(Color.RED)
                                .title("Comando no reconocido")
                                .addField("Si necesitas una lista de comandos escribe:", "\"!help\"", false)
                                .addField("Si necesitas información de un comando concreto, escribe:", "\"!help !comando\"", false)
                                .build()).block();

                    else triggerable.run(comand[1], channel);
                } else channel.createMessage(EmbedCreateSpec.builder()
                        .color(Color.RED)
                        .title("Comando Incorrecto")
                        .description("Los comandos solo tienen dos estructuras:")
                        .addField("Comando Simple:", "\"!comand\"", false)
                        .addField("Comando Parametrizado:", "\"!comand parametro\"", false)
                        .build()).block();

            }


        });

        gateway.onDisconnect().block();

    }


}
