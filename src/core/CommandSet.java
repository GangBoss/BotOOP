package core;

import java.util.List;

public interface CommandSet
{
    public void Add(Command command);

    public boolean tryFindCommand(String commandName, final Command command);
}
