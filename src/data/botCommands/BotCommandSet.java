package data.botCommands;

import core.BasicSet;
import core.CommandBase;
import data.botCommands.ExitCommand;
import data.botCommands.ListCommand;
import data.botCommands.QuizCommand;

import java.util.HashMap;

public class BotCommandSet extends BasicSet<CommandBase, HashMap<String,CommandBase>>
{
    public BotCommandSet()
    {
        set = new HashMap<>();
        prefixCount = 0;
        suffixCount = 7;

        add(new ListCommand(this));
        add(new QuizCommand());
        add(new ExitCommand());
        add(new StartCommand());
        add(new AnonymousCommand());
    }
}
