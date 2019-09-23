package games.quiz.commands;

import core.CommandBase;
import core.MessageHandleable;
import core.User;
import games.quiz.Quiz;

public class ExitQuizCommand extends CommandBase
{
    public ExitQuizCommand()
    {
        super("Exit from quiz game");
    }

    @Override
    public void execute(MessageHandleable quiz, User user)
    {
        ((Quiz) quiz).stop(user);
    }
}
