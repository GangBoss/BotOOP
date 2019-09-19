package games.quiz.commands;

import core.CommandBase;
import core.MessageHandlable;
import core.User;
import games.quiz.Quiz;

public class NextQuizCommand extends CommandBase
{

    public NextQuizCommand()
    {
        super("Change question on Quiz");
    }

    @Override
    public void execute(MessageHandlable bot, User user)
    {
        ((Quiz)bot).next(user);
    }
}
