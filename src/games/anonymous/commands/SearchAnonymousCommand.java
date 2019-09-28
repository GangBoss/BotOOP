package games.anonymous.commands;

import core.CommandBase;
import core.MessageHandler;
import core.User;
import games.anonymous.Anonymous;

public class SearchAnonymousCommand extends CommandBase
{

    public SearchAnonymousCommand()
    {
        super("Find pair");
    }

    @Override
    public void execute(MessageHandler bot, User user)
    {
        ((Anonymous)bot).searcher.search(user);
    }
}

