package data.botCommands;

import core.Bot;
import core.CommandBase;
import core.MessageHandleable;
import core.User;

public class
AnonymousCommand extends CommandBase
{
    public AnonymousCommand()
    {
        super("Start anonymous chat");
    }

    @Override
    public void execute(MessageHandleable bot, User user)
    {
        ((Bot)bot).games.find("anonymous").start(user);
    }
}
