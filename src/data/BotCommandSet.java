package data;

import core.BasicSet;
import core.CommandBase;
import data.commands.ExitCommand;
import data.commands.ListCommand;
import data.commands.QuizCommand;

public class BotCommandSet extends BasicSet<CommandBase>
{
    public BotCommandSet()
    {
        prefixCount = 0;
        suffixCount = 7;

        add(new ListCommand(this));
        add(new QuizCommand());
        add(new ExitCommand());
    }
}
