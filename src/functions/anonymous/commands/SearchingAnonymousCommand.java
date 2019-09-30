package functions.anonymous.commands;

import core.CommandBase;
import core.User;
import functions.anonymous.Anonymous;

public class SearchingAnonymousCommand extends CommandBase<Anonymous>
{

    public SearchingAnonymousCommand()
    {
        super("Show how many searchers online");
    }

    @Override
    public void execute(Anonymous bot, User user)
    {
        bot.searcher.searching(user);
    }
}
