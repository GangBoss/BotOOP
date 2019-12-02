package functions.anonymous.commands;

import core.CommandBase;
import core.Message;
import core.User;
import functions.anonymous.Anonymous;

public class SearchingAnonymousCommand extends CommandBase<Anonymous>
{

    SearchingAnonymousCommand()
    {
        super("Show how many searchers online");
    }

    @Override
    public void execute(Anonymous bot, Message message)
    {
        bot.searcher.searching(message.getUser());
    }
}
