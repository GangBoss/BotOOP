package data.botCommands;

import core.set.CommandSet;

import java.util.HashMap;

public class BotCommandSet extends CommandSet
{
    public BotCommandSet()
    {
        super(0,"command".length(),"/");

        add(new QuizCommand());
        add(new ExitCommand());
        add(new StartCommand());
        add(new AnonymousCommand());
    }
}
