package data.botCommands;

import core.Bot;
import core.CommandBase;
import core.MessageHandler;
import core.User;
import games.GameType;

public class
AnonymousCommand extends CommandBase
{
    public AnonymousCommand()
    {
        super("Start anonymous chat");
    }

    @Override
    public void execute(MessageHandler bot, User user)
    {
        ((Bot) bot).startGame(user, GameType.Anonymous);
    }
}
