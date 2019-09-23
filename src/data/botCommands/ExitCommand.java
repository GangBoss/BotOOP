package data.botCommands;

import core.*;

public class ExitCommand extends CommandBase
{

    public ExitCommand()
    {
        super("Exit from program.");
        includingPlatforms.add("console");
    }

    @Override
    public void execute(MessageHandleable bot, User user)
    {
        if (!hasIncludingPlatform(user.userPlatform))
            bot.sendMessage(new Message("Invalid command", user));
        else ((Bot) bot).stop();
    }
}
