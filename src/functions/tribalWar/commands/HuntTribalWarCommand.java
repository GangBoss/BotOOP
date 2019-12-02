package functions.tribalWar.commands;

import core.CommandBase;
import core.Message;
import core.MessageHandler;
import functions.tribalWar.TribalWar;

public class HuntTribalWarCommand extends CommandBase<TribalWar>
{
    HuntTribalWarCommand()
    {
        super("send villages to the hunt /hunt param");
    }

    @Override
    public void execute(TribalWar bot, Message message)
    {
            bot.hunt(message);
    }
}
