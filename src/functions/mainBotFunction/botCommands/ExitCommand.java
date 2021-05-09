package data.botCommands;

import core.*;

public class ExitCommand extends CommandBase<Bot>
{

    ExitCommand()
    {
        super("Exit from program.");
        includingPlatforms.add(PlatformType.Console);
    }

    @Override
    public void execute(Bot bot, Message message)
    {
        var user = message.getUser();
        if (hasIncludingPlatform(user.getUserPlatform()))
            bot.sendMessage(new Message("Invalid command", user));
        else bot.stop();
    }
}
