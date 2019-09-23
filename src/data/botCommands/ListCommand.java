package data.botCommands;

import core.*;

public class ListCommand extends CommandBase
{
    private BotCommandSet commands;

    public ListCommand(BotCommandSet commands)
    {
        super("Print all commands");
        this.commands = commands;
    }

    @Override
    public void execute(MessageHandleable handler, User user)
    {
        StringBuilder result = new StringBuilder();
        for (var command : commands.getAll())
        {
            if (!command.hasIncludingPlatform(user.userPlatform))
                continue;
            Class<?> enclosingClass = command.getClass().getEnclosingClass();
            String name;
            if (enclosingClass != null)
                name = enclosingClass.getSimpleName().toLowerCase();
            else name = command.getClass().getSimpleName().toLowerCase();
            name = commands.getCommandPrefix() + name.substring(commands.getPrefixCount(), name.length() - commands.getSuffixCount());

            result.append(String.format("%s\t-\t %s\n", name, command.info));
        }
        handler.sendMessage(new Message(result.toString(), user));
    }
}
