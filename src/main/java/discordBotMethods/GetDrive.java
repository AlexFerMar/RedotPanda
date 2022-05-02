package discordBotMethods;

import DriveConnection.ImagesDrive;
import discord4j.core.object.entity.channel.MessageChannel;
import discord4j.core.spec.EmbedCreateSpec;
import discord4j.rest.util.Color;
import discordBot.Triggerable;

import java.io.File;


public class GetDrive implements Triggerable {


    private final String COMAND = "!getDrive";

    private final String DESCRIPTION = "Comando con el que puedes ver una imagen disponible en la carpeta \"" + ImagesDrive.FOLDER_NAME + "\" de la persona que lanza el comando. Para ello solo deberas escribir \"!get nombre.extension\". Si deseas ver la lista de imagenes disponibles, emplea el comando \"!listDrive\". ";

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

            String check = new ImagesDrive().downloadFile(parameter);

            if (check == null) new Get().run(ImagesDrive.FILE_NAME, channel);

            else channel.createMessage(EmbedCreateSpec.builder()
                    .color(Color.RED)
                    .title("Error")
                    .description(check)
                    .build()).block();


        } else
            channel.createMessage(EmbedCreateSpec.builder()
                    .color(Color.RED)
                    .title("Error")
                    .description("El comando \"!getDrive\" debe llevar como parametro el nombre de la imagen a mostrar. Param más ayuda emplea el comando \"!help !getDrive\".")
                    .build()).block();


    }


}
