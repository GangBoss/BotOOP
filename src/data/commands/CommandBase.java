package data.commands;


import core.Command;

public abstract class CommandBase implements Command
{
    final String info;

    public CommandBase(String info)
    {
        this.info = info;
    }
}
