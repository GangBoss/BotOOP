package data.commands;

import core.MessageHandlable;
import core.User;
import data.CommandSet;

public class ListCommand extends CommandBase
{
    private CommandSet commands;

    public ListCommand(CommandSet commands)
    {
        super("Print all commands");
        this.commands = commands;
    }

    @Override
    public void execute(MessageHandlable handler, User user)
    {
        StringBuilder result = new StringBuilder();
        for (var command : commands.getAll())
        {
            Class<?> enclosingClass = command.getClass().getEnclosingClass();
            String name;
            if (enclosingClass != null)
                name = enclosingClass.getSimpleName().toLowerCase();
            else name = command.getClass().getSimpleName().toLowerCase();
            name = name.substring(0, name.length() - 7);

            result.append(String.format("%s\t-\t %s\n", name, command.info));
        }
        handler.sendMessage(result.toString(), user);
    }
}
