package data.botCommands;

import core.CommandBase;
import core.Message;
import core.MessageHandler;
import core.User;
import core.set.CommandSet;

public class ListCommand extends CommandBase
{
    private CommandSet commands;

    public ListCommand(CommandSet commands)
    {
        super("Print all commands");
        this.commands = commands;
    }

    @Override
    public void execute(MessageHandler handler, User user)
    {
        handler.sendMessage(new Message(commands.getCommandList(), user));
    }
}
