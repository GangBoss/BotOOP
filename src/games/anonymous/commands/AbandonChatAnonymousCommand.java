package games.anonymous.commands;

import core.CommandBase;
import core.MessageHandler;
import core.User;
import games.anonymous.Anonymous;

public class AbandonChatAnonymousCommand extends CommandBase
{
    public AbandonChatAnonymousCommand()
    {
        super("Abbaadon from chat");
    }

    @Override
    public void execute(MessageHandler anonymous, User user)
    {
        ((Anonymous) anonymous).searcher.abandonChat(user);
    }
}
