package data.botCommands;

import core.Bot;
import core.CommandBase;
import core.Message;
import core.User;
import functions.FunctionType;

public class
AnonymousCommand extends CommandBase<Bot>
{
    AnonymousCommand()
    {
        super("Start anonymous chat");
    }

    @Override
    public void execute(Bot bot, Message message)
    {
        bot.startGame(message.getUser(), FunctionType.Anonymous);
    }
}
