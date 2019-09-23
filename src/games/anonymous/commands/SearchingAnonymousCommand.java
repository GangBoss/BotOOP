package games.anonymous.commands;

import core.CommandBase;
import core.MessageHandleable;
import core.User;
import games.anonymous.Anonymous;

public class SearchingAnonymousCommand extends CommandBase
{

    public SearchingAnonymousCommand()
    {
        super("Show how many searchers online");
    }

    @Override
    public void execute(MessageHandleable bot, User user)
    {
        ((Anonymous)bot).searcher.searching(user);
    }
}
