package discordBotMethods;

import discord4j.core.object.entity.channel.MessageChannel;
import discord4j.core.spec.EmbedCreateSpec;
import discord4j.rest.util.Color;
import discordBot.Triggerable;

import java.io.File;

public class List implements Triggerable {

    private final static String PATH = "src" + java.io.File.separator + "App" + java.io.File.separator + "resources" + java.io.File.separator + "images" + java.io.File.separator;

    private final String COMAND = "!list";

    private final String DESCRIPTION = "Comando con el que obtener la lista de imágenes disponibles. Si quieres visualizar alguna imagen, pon \"!get nombre.extensión\".";

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

        if (parameter == null) {

            String fileList = "";

            //En esta linea, el new File(PATH).list(), genera una array de String con todos los ficheros en la dirección dada.
            for (String fileName : new File(PATH).list()) {

                fileList += fileName + " ,";
            }

            fileList = fileList.substring(0, fileList.length() - 2) + ".";


            embed = EmbedCreateSpec.builder()
                    .color(Color.SEA_GREEN)
                    .title("Lista de imágenes")
                    .description(fileList)
                    .build();

        } else embed = EmbedCreateSpec.builder()
                .color(Color.RED)
                .title("Error")
                .description("El comando \"!list\" no lleva parámetros")
                .build();

        channel.createMessage(embed).block();
    }
}
