package games.anonymous.commands;

import core.CommandBase;
import core.MessageHandleable;
import core.User;
import games.anonymous.Anonymous;

public class SearchAnonymousCommand extends CommandBase
{

    public SearchAnonymousCommand()
    {
        super("Find pair");
    }

    @Override
    public void execute(MessageHandleable bot, User user)
    {
        ((Anonymous)bot).searcher.search(user);
    }
}

