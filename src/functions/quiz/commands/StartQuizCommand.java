package functions.quiz.commands;

import core.CommandBase;
import core.Message;
import core.User;
import functions.quiz.Quiz;

public class StartQuizCommand extends CommandBase<Quiz>
{
    public StartQuizCommand()
    {
        super("Start Quiz");
    }

    @Override
    public void execute(Quiz bot, Message message)
    {
        bot.askQuestion(message.getUser());
    }
}

