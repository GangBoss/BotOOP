package functions.quiz.commands;

import core.CommandBase;
import core.User;
import functions.quiz.Quiz;

public class NextQuizCommand extends CommandBase<Quiz>
{

    public NextQuizCommand()
    {
        super("Change question on Quiz");
    }

    @Override
    public void execute(Quiz bot, User user)
    {
        bot.next(user);
    }
}
