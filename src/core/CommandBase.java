package core;


import core.Command;

public abstract class CommandBase implements Command
{
    public final String info;

    public CommandBase(String info)
    {
        this.info = info;
    }
}
