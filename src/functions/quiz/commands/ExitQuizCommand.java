package functions.quiz.commands;

import core.CommandBase;
import core.User;
import functions.quiz.Quiz;

public class ExitQuizCommand extends CommandBase<Quiz>
{
    public ExitQuizCommand()
    {
        super("Exit from quiz game");
    }

    @Override
    public void execute(Quiz quiz, User user)
    {
        quiz.stop(user);
    }
}
