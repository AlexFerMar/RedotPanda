package discordBotMethods;

import discord4j.core.object.entity.channel.MessageChannel;
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

        if (parameter==null){

            System.out.println("Salida1");

        }else{

            System.out.println("Salida2");


        }



    }
}
