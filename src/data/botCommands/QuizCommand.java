package data.botCommands;

import core.Bot;
import core.CommandBase;
import core.MessageHandleable;
import core.User;

public class QuizCommand extends CommandBase
{
    public QuizCommand()
    {
        super("Start playing quiz");
    }

    @Override
    public void execute(MessageHandleable bot, User user)
    {
        ((Bot)bot).games.find("quiz").start(user);
    }
}
