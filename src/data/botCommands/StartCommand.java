package data.botCommands;

import core.CommandBase;
import core.Message;
import core.MessageHandler;
import core.User;

public class StartCommand extends CommandBase
{
    StartCommand()
    {
        super("Get starting message");
    }

    @Override
    public void execute(MessageHandler bot, Message message)
    {
        bot.sendMessage(new Message("Hello, I'm a bot.", message.getUser()));
        bot.sendMessage(new Message("Enter \"/list\" to view all commands.", message.getUser()));
    }
}
