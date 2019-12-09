package functions.tribalWar.commands;

import core.CommandBase;
import core.Message;
import core.MessageHandler;
import functions.tribalWar.TribalWar;

public class ChopTribalWarCommand extends CommandBase<TribalWar>
{
    ChopTribalWarCommand()
    {
        super("send villages to chop /chop param");
    }

    @Override
    public void execute(TribalWar bot, Message message)
    {
        var param=getNumericParam(message.text);
         bot.chop(message.getUser(),param);
    }
}
