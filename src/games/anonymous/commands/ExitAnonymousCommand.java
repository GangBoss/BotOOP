package games.anonymous.commands;

import core.CommandBase;
import core.MessageHandlable;
import core.User;
import games.anonymous.Anonymous;

public class ExitAnonymousCommand extends CommandBase
{
    public ExitAnonymousCommand()
    {
        super("Exit from anonymous");
    }

    @Override
    public void execute(MessageHandlable anonymous, User user)
    {
        ((Anonymous) anonymous).stop(user);
    }
}



