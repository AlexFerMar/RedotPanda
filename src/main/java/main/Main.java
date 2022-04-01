package main;

import discordBot.BotGateway;
import discordBot.BotMessage;

public class Main {

    public static void main(final String[] args) {

        BotGateway gateway=new BotGateway();

        BotMessage.sendMessage(gateway.getGateway());


    }
}
