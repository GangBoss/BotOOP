package games.anonymous.commands;

import core.CommandBase;
import core.MessageHandler;
import core.User;
import games.anonymous.Anonymous;

public class SearchingAnonymousCommand extends CommandBase
{

    public SearchingAnonymousCommand()
    {
        super("Show how many searchers online");
    }

    @Override
    public void execute(MessageHandler bot, User user)
    {
        ((Anonymous) bot).searcher.searching(user);
    }
}
