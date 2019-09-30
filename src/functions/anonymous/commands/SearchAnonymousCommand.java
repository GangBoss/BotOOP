package functions.anonymous.commands;

import core.CommandBase;
import core.User;
import functions.anonymous.Anonymous;

public class SearchAnonymousCommand extends CommandBase<Anonymous>
{

    public SearchAnonymousCommand()
    {
        super("Find pair");
    }

    @Override
    public void execute(Anonymous bot, User user)
    {
        bot.searcher.search(user);
    }
}

