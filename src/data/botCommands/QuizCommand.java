package data.botCommands;

import core.Bot;
import core.CommandBase;
import core.User;
import functions.FunctionType;

public class QuizCommand extends CommandBase<Bot>
{
    public QuizCommand()
    {
        super("Start playing quiz");
    }

    @Override
    public void execute(Bot bot, User user)
    {
        bot.startGame(user, FunctionType.Quiz);
    }
}
