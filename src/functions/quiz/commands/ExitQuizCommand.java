package functions.quiz.commands;

import core.CommandBase;
import core.Message;
import core.User;
import functions.quiz.Quiz;

public class ExitQuizCommand extends CommandBase<Quiz>
{
    ExitQuizCommand()
    {
        super("Exit from quiz game");
    }

    @Override
    public void execute(Quiz quiz, Message message)
    {
        quiz.stop(message.getUser());
    }
}
