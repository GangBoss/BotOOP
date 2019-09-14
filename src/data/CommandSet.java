package data;

import core.Command;
import data.commands.CommandBase;
import data.commands.ExitCommand;
import data.commands.ListCommand;
import data.commands.QuizCommand;

import java.util.Collection;
import java.util.HashMap;

public class CommandSet
{
    private HashMap<String, CommandBase> commands = new HashMap<String, CommandBase>();

    public CommandSet()
    {
        add(new ListCommand(this));
        add(new QuizCommand());
        add(new ExitCommand());
    }

    private void add(CommandBase command)
    {
        Class<?> enclosingClass = command.getClass().getEnclosingClass();
        String name;
        if (enclosingClass != null)
            name = enclosingClass.getSimpleName().toLowerCase();
        else name = command.getClass().getSimpleName().toLowerCase();
        name = name.substring(0, name.length() - 7);
        commands.put(name,command);
    }

    public Command find(String name)
    {
        return commands.getOrDefault(name, null);
    }

    public boolean hasCommand(String name)
    {
        return commands.containsKey(name);
    }

    public Collection<CommandBase> getAll()
    {
        return commands.values();
    }
}
