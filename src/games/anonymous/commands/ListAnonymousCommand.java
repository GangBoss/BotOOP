package games.anonymous.commands;

import data.botCommands.ListCommand;

public class ListAnonymousCommand extends ListCommand
{

    public ListAnonymousCommand(AnonymousCommandSet commands)
    {
        super(commands);
        this.info = "Print all commands";
    }
}