package functions.anonymous.commands;

import core.CommandBase;
import core.Message;
import core.User;
import functions.anonymous.Anonymous;

import java.lang.reflect.Member;

public class SearchAnonymousCommand extends CommandBase<Anonymous>
{

    SearchAnonymousCommand()
    {
        super("Find pair");
    }

    @Override
    public void execute(Anonymous bot, Message message)
    {
        bot.searcher.search(message.getUser());
    }
}

