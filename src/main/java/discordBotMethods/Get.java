package discordBotMethods;

import discord4j.core.object.entity.channel.MessageChannel;
import discord4j.core.spec.EmbedCreateSpec;
import discord4j.core.spec.MessageCreateSpec;
import discord4j.rest.util.Color;
import discordBot.Triggerable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Get implements Triggerable {

    private final static String PATH = "src" + java.io.File.separator + "main" + java.io.File.separator + "resources" + java.io.File.separator+ "images" + java.io.File.separator;

    private final String COMAND = "!get";

    private final String DESCRIPTION = "Comando con el que puedes ver una imagen almacenada en el bot poniendo \"!get nombre.extensión\". Si deseas ver la lista de imágenes disponibles, emplea el comando \"!list\". ";

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

            if (new File(PATH + parameter).exists()) {
                embed = EmbedCreateSpec.builder()
                        .color(Color.SEA_GREEN)
                        .title(parameter)
                        .image("attachment://" + parameter)
                        .build();
                FileInputStream imageAsImputStream = null;

                try {
                    imageAsImputStream = new FileInputStream(new File(PATH + parameter));
                    channel.createMessage(MessageCreateSpec.builder().addFile(parameter, imageAsImputStream).addEmbed(embed).build()).block();

                } catch (FileNotFoundException e) {

                    e.printStackTrace();

                } finally {
                    try {

                        imageAsImputStream.close();

                    } catch (IOException e) {

                        e.printStackTrace();

                    }
                    return;
                }

            } else embed = EmbedCreateSpec.builder()
                    .color(Color.RED)
                    .title("Error")
                    .description("El archivo \"" + parameter + "\" no existe. Para ver una lista de los archivos disponibles, emplea el comando \"!list\".")
                    .build();

        } else
            embed = EmbedCreateSpec.builder()
                    .color(Color.RED)
                    .title("Error")
                    .description("El comando \"!get\" debe llevar como parámetro el nombre de la imagen a mostrar. Para más ayuda emplea el comando \"!help !get\".")
                    .build();


        channel.createMessage(embed).block();

    }
}
