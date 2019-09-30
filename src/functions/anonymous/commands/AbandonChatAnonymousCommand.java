package functions.anonymous.commands;

import core.CommandBase;
import core.MessageHandler;
import core.User;
import functions.anonymous.Anonymous;

public class AbandonChatAnonymousCommand extends CommandBase
{
    public AbandonChatAnonymousCommand()
    {
        super("Abandon from chat");
    }

    @Override
    public void execute(MessageHandler anonymous, User user)
    {
        ((Anonymous) anonymous).searcher.abandonChat(user);
    }
}
