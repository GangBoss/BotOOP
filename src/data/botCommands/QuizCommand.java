package data.botCommands;

import core.Bot;
import core.CommandBase;
import core.MessageHandler;
import core.User;
import games.GameType;

public class QuizCommand extends CommandBase
{
    public QuizCommand()
    {
        super("Start playing quiz");
    }

    @Override
    public void execute(MessageHandler bot, User user)
    {
        ((Bot) bot).startGame(user, GameType.Quiz);
    }
}
