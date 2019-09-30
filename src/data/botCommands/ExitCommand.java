package data.botCommands;

import core.*;

public class ExitCommand extends CommandBase<Bot>
{

    public ExitCommand()
    {
        super("Exit from program.");
        includingPlatforms.add(PlatformType.Console);
    }

    @Override
    public void execute(Bot bot, User user)
    {
        if (hasIncludingPlatform(user.getUserPlatform()))
            bot.sendMessage(new Message("Invalid command", user));
        else bot.stop();
    }
}
