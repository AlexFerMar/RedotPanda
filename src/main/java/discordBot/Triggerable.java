package discordBot;

import discord4j.core.object.entity.channel.MessageChannel;

public interface Triggerable {

    public String getCOMAND();

    public String getDescription();


    public void run(String parameter,MessageChannel channel);

}
