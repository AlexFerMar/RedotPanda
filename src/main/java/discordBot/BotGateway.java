package discordBot;

import discord4j.core.DiscordClient;
import discord4j.core.GatewayDiscordClient;

public class BotGateway {

    //Creación del bot mediante un token obtenido de la página de developer de Discord
    private final String TOKEN = "TOKEN";

    private GatewayDiscordClient gateway = null;

    public GatewayDiscordClient getGateway() {
        return gateway;
    }


    public BotGateway() {

        this.gateway = DiscordClient.create(TOKEN).login().block();

    }
}
