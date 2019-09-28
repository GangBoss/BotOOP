package data.botCommands;

import core.CommandBase;
import core.set.StringSet;

import java.util.HashMap;

public class BotCommandSet extends StringSet<CommandBase>
{
    public BotCommandSet()
    {
        set = new HashMap<>();
        prefixCount = 0;
        suffixCount = 7;
        commandPrefix = "/";

        add(new ListCommand(this));
        add(new QuizCommand());
        add(new ExitCommand());
        add(new StartCommand());
        add(new AnonymousCommand());
    }
}
