package games.quiz.commands;

import core.CommandBase;
import core.MessageHandler;
import core.User;
import games.quiz.Quiz;

public class ExitQuizCommand extends CommandBase
{
    public ExitQuizCommand()
    {
        super("Exit from quiz game");
    }

    @Override
    public void execute(MessageHandler quiz, User user)
    {
        ((Quiz) quiz).stop(user);
    }
}
