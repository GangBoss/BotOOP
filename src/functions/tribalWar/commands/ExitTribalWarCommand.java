package functions.tribalWar.commands;

import core.CommandBase;
import core.Message;
import functions.tribalWar.TribalWar;

public class ExitTribalWarCommand extends CommandBase<TribalWar>
{
    ExitTribalWarCommand()
    {
        super("Exit tribal war");
    }

    @Override
    public void execute(TribalWar bot, Message message)
    {
        bot.stop(message.getUser());
    }
}
