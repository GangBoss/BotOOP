package games.anonymous.commands;

import core.CommandBase;
import core.MessageHandlable;
import core.User;
import games.anonymous.Anonymous;

public class SearchPairAnonymousCommand extends CommandBase
{

    public SearchPairAnonymousCommand()
    {
        super("Find pair");
    }

    @Override
    public void execute(MessageHandlable bot, User user)
    {
        ((Anonymous)bot).search(user);
    }
}

