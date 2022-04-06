package discordBot;

import discord4j.core.DiscordClient;
import discord4j.core.GatewayDiscordClient;

public class BotGateway {

    //Creacion del bot mediante un token obtenido de la pagina de developer de discord
    private final String TOKEN = "OTU0MjkxNjAyMTkxNDMzNzc4.YjQ_Tw.6QPhwZU6JwNMHF1-ABDznDVFUH8";

    private GatewayDiscordClient gateway = null;

    public GatewayDiscordClient getGateway() {
        return gateway;
    }

    public BotGateway() {

        this.gateway = DiscordClient.create(TOKEN).login().block();

    }
}
