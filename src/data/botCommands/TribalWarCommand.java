package data.botCommands;

import core.Bot;
import core.CommandBase;
import core.Message;
import functions.FunctionType;

public class TribalWarCommand extends CommandBase<Bot>
{
    TribalWarCommand()
    {
        super("Start tribal war chat");
    }

    @Override
    public void execute(Bot bot, Message message)
    {
        bot.startGame(message.getUser(), FunctionType.TribalWar);
    }
}

