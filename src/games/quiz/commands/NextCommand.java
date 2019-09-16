package games.quiz.commands;

import core.CommandBase;
import core.MessageHandlable;
import core.User;
import games.quiz.Quiz;

public class NextCommand extends CommandBase
{

    public NextCommand()
    {
        super("Change question on Quiz");
    }

    @Override
    public void execute(MessageHandlable bot, User user)
    {
        ((Quiz)bot).next(user);
    }
}
