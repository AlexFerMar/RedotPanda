package discordBot;

import discord4j.core.DiscordClient;
import discord4j.core.GatewayDiscordClient;

public class BotGateway {

    //Creación del bot mediante un token obtenido de la página de developer de Discord
    private final String TOKEN = "OTU0MjkxNjAyMTkxNDMzNzc4.YjQ_Tw.oYe-lBX_djIlDbxg0zYUNkiQ25k";

    private GatewayDiscordClient gateway = null;

    public GatewayDiscordClient getGateway() {
        return gateway;
    }


    public BotGateway() {

        this.gateway = DiscordClient.create(TOKEN).login().block();

    }
}
