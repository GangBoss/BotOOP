package functions.anonymous.commands;

import core.CommandBase;
import core.Message;
import core.MessageHandler;
import core.User;
import functions.anonymous.Anonymous;

public class AbandonChatAnonymousCommand extends CommandBase
{
    AbandonChatAnonymousCommand()
    {
        super("Abandon from chat");
    }

    @Override
    public void execute(MessageHandler anonymous, Message message)
    {
        ((Anonymous) anonymous).searcher.abandonChat(message.getUser());
    }
}
