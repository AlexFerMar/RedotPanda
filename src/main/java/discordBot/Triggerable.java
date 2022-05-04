package discordBot;

import discord4j.core.object.entity.channel.MessageChannel;

public interface Triggerable {

    /**
     * Getter para el comando de la clase triggereable
     *
     * @return El comando que sirve para llamar la clase en el chat
     */
    public String getCOMAND();

    /**
     * Getter para la descripción de la clase de Discord
     *
     * @return Un String con la descripción de lo que hace la clase al usar la función run
     */
    public String getDescription();

    /**
     * Función que varía en resultado según la clase del tipo triggereable que la llame
     *
     * @param parameter El parámetro varía en utilidad dependiendo de que clase llame la función run
     * @param channel   El canal donde fue enviado el mensaje de Discord
     */
    public void run(String parameter, MessageChannel channel);

}
