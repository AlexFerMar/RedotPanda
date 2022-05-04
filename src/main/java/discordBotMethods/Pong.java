package discordBotMethods;

import discord4j.core.object.entity.channel.MessageChannel;
import discord4j.core.spec.EmbedCreateSpec;
import discord4j.rest.util.Color;
import discordBot.Triggerable;

public class Pong implements Triggerable {

    private final String COMAND = "!ping";
    private final String DESCRIPTION = "El bot contestará a este comando poniendo \"Pong\".";

    @Override
    public String getCOMAND() {
        return COMAND;
    }

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }

    @Override
    public void run(String parameter, MessageChannel channel) {

        if (parameter == null) channel.createMessage("Pong").block();

        else channel.createMessage(EmbedCreateSpec.builder()
                .color(Color.RED)
                .title("Error")
                .description("El comando \"!ping\" no lleva parámetros")
                .build()).block();
    }
}
