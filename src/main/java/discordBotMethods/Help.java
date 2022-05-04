package discordBotMethods;

import discord4j.core.object.entity.channel.MessageChannel;
import discord4j.core.spec.EmbedCreateSpec;
import discord4j.rest.util.Color;
import discordBot.TriggerMethods;
import discordBot.Triggerable;

import java.time.Instant;

public class Help implements Triggerable {

    private final String COMAND = "!help";
    private final String DESCRIPTION = "Comando de ayuda. Si se escribe \"!help\" sin ningún otro parametro, salta una lista de todos los comandos. Si se escribe \"!help !comando\" se mostrara una breve descripción del mismo (como esta).";

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

        EmbedCreateSpec embed;

        if (parameter != null) {
            Triggerable trigger = TriggerMethods.getTrigger(parameter);
            if (trigger != null) {
                embed = EmbedCreateSpec.builder()
                        .color(Color.SEA_GREEN)
                        .title(trigger.getCOMAND())
                        .description(trigger.getDescription())
                        .build();
            } else embed = EmbedCreateSpec.builder()
                    .color(Color.RED)
                    .title("Error")
                    .description("Comando \"" + parameter + "\" no reconocido")
                    .build();
        } else {
            String comands = "";
            for (Triggerable x : TriggerMethods.listTrigger) {

                comands += x.getCOMAND() + ", ";

            }
            comands = comands.substring(0, comands.length() - 2) + ".";

            embed = EmbedCreateSpec.builder()
                    .color(Color.SEA_GREEN)
                    .title("Comandos")
                    .description(comands)
                    .build();
        }

        channel.createMessage(embed).block();

    }
}
