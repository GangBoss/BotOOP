package data.commands;

import core.Bot;
import core.CommandBase;
import core.MessageHandlable;
import core.User;

public class ExitCommand extends CommandBase
{
    public ExitCommand()
    {
        super("Exit from program.");
    }

    @Override
    public void execute(MessageHandlable bot, User user)
    {
        ((Bot)bot).stop();
    }
}
