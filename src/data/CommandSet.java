package data;

import core.BasicSet;
import core.Command;
import data.commands.CommandBase;
import data.commands.ExitCommand;
import data.commands.ListCommand;
import data.commands.QuizCommand;

import java.util.Collection;
import java.util.HashMap;

public class CommandSet extends BasicSet<CommandBase>
{
    public CommandSet()
    {
        prefixCount = 0;
        suffixCount = 7;

        add(new ListCommand(this));
        add(new QuizCommand());
        add(new ExitCommand());
    }
}
