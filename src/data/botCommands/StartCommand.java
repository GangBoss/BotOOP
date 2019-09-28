package data.botCommands;

import core.*;

public class StartCommand extends CommandBase
{
    public StartCommand()
    {
        super("Get starting message");
    }

    @Override
    public void execute(MessageHandler bot, User user)
    {
        bot.sendMessage(new Message("Hello, I'm a bot.", user));
        bot.sendMessage(new Message("Enter \"/list\" to view all commands.", user));
    }
}
