package games.quiz.commands;

import core.CommandBase;
import core.MessageHandler;
import core.User;
import games.quiz.Quiz;

public class NextQuizCommand extends CommandBase
{

    public NextQuizCommand()
    {
        super("Change question on Quiz");
    }

    @Override
    public void execute(MessageHandler bot, User user)
    {
        ((Quiz)bot).next(user);
    }
}
