package data.botCommands;

import core.Bot;
import core.CommandBase;
import core.User;
import functions.FunctionType;

public class
AnonymousCommand extends CommandBase<Bot>
{
    public AnonymousCommand()
    {
        super("Start anonymous chat");
    }

    @Override
    public void execute(Bot bot, User user)
    {
        bot.startGame(user, FunctionType.Anonymous);
    }
}
