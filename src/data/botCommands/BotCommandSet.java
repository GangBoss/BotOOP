package data.botCommands;

import core.set.CommandSet;
import functions.tribalWar.TribalWar;

import java.util.HashMap;

public class BotCommandSet extends CommandSet
{
    public BotCommandSet()
    {
        super(0,7,"/");

        add(new QuizCommand());
        add(new ExitCommand());
        add(new StartCommand());
        add(new AnonymousCommand());
        add(new TribalWarCommand());
    }
}
