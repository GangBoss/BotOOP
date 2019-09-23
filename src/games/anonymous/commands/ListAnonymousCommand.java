package games.anonymous.commands;

import core.CommandBase;
import core.Message;
import core.MessageHandleable;
import core.User;
import data.botCommands.BotCommandSet;
import data.botCommands.ListCommand;

public class ListAnonymousCommand extends ListCommand
{

    public ListAnonymousCommand(AnonymousCommandSet commands)
    {
        super(commands);
        this.info="Print all commands";
    }
}