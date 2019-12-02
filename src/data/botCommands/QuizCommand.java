package data.botCommands;

import core.Bot;
import core.CommandBase;
import core.Message;
import core.User;
import functions.FunctionType;

public class QuizCommand extends CommandBase<Bot>
{
    QuizCommand()
    {
        super("Start playing quiz");
    }

    @Override
    public void execute(Bot bot, Message message)
    {
        bot.startGame(message.getUser(), FunctionType.Quiz);
    }
}
