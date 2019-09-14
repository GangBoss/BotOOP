package data.commands;

import core.CommandBase;
import core.MessageHandlable;
import core.User;
import data.BotCommandSet;

public class ListCommand extends CommandBase
{
    private BotCommandSet commands;

    public ListCommand(BotCommandSet commands)
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
