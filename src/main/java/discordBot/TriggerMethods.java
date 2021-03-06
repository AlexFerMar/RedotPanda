package discordBot;

import discord4j.core.object.entity.Message;
import discordBotMethods.*;

import java.util.ArrayList;
import java.util.Collection;

public class TriggerMethods {

    /**
     * Lista de todos los triggers que el bot detectara en el chat
     */
    public static Collection<Triggerable> listTrigger = new ArrayList<Triggerable>() {
        {
            add(new Help());
            add(new Pong());
            add(new Get());
            add(new List());
            add(new GetDrive());
            add(new ListDrive());
            add(new Pdf());
        }
    };

    /**
     * Revisa si el mensaje
     *
     * @param message
     * @return
     */
    public static String[] splitComand(Message message) {


        String[] comand = message.getContent().replaceAll(" +", " ").split(" ");

        if (comand.length == 1) return new String[]{comand[0], null};

        return comand;
    }

    public static Triggerable getTrigger(String comand) {
        return listTrigger.stream().filter(trigger -> comand.equalsIgnoreCase(trigger.getCOMAND())).findFirst().orElse(null);
    }


}
