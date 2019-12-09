package functions.tribalWar.commands;

import core.CommandBase;
import core.Message;
import functions.tribalWar.TribalWar;

public class GetInformationTribalWarCommand extends CommandBase<TribalWar>
{
    GetInformationTribalWarCommand()
    {
        super("Get information about your village");
    }

    @Override
    public void execute(TribalWar bot, Message message)
    {
        bot.sendInformation(message.getUser());
    }
}
