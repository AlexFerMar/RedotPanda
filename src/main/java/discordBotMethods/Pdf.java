package discordBotMethods;


import DriveConnection.PdfDrive;
import discord4j.core.object.entity.channel.MessageChannel;
import discord4j.core.spec.EmbedCreateSpec;
import discord4j.rest.util.Color;
import discordBot.Triggerable;

public class Pdf implements Triggerable {

    private final String COMAND = "!pdf";
    private final String DESCRIPTION = "Comando con el que puedes descargar un pdf con el bot poniendo \"!pdf nombre.extensión\". Si deseas ver los archivos disponibles pon  \"!pdf\" sin parametros. ";


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

        String message;

        //Esto lista los pdf
        if (parameter == null)  message = PdfDrive.fileSearcher();

        //Esto descarga el pdf en caso de existir
        else message = PdfDrive.downloadPDF(parameter);


        channel.createMessage(EmbedCreateSpec.builder()
                .color(Color.SEA_GREEN)
                .title("Archivos del Drive")
                .description(message)
                .build()).block();

    }
}
