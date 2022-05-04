package discordBotMethods;

import DriveConnection.ImagesDrive;
import discord4j.core.object.entity.channel.MessageChannel;
import discord4j.core.spec.EmbedCreateSpec;
import discord4j.rest.util.Color;
import discordBot.Triggerable;


public class ListDrive implements Triggerable {

    private final String COMAND = "!listDrive";

    private final String DESCRIPTION = "Comando con el que obtener la lista de imágenes disponibles en la carpeta \" " + ImagesDrive.FOLDER_NAME + "\" de la persona que lanza el comando. Para limitar la visibilidad del bot a los archivos, solo revisará las imágenes de la carpeta \"fotosBot\", recuerda crear la carpeta en tu drive y meter allí las fotos que deseas pasar con el bot. Si quieres visualizar alguna imagen, pon \"!getDrive nombre.extensión\".";

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

            embed = EmbedCreateSpec.builder()
                    .color(Color.SEA_GREEN)
                    .title("Lista de imagenes de " + "Username")
                    .description(ImagesDrive.imageSearcher())
                    .build();

        } else embed = EmbedCreateSpec.builder()
                .color(Color.RED)
                .title("Error")
                .description("El comando \"!list\" no lleva parametros")
                .build();

        channel.createMessage(embed).block();
    }
}
