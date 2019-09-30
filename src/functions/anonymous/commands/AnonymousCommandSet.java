package functions.anonymous.commands;

import core.set.CommandSet;

import java.util.HashMap;

public class AnonymousCommandSet extends CommandSet
{
    public AnonymousCommandSet()
    {
        set = new HashMap<>();
        suffixCount = "AnonymousCommand".length();
        prefixCount = 0;
        commandPrefix = "/";

        add(new ListAnonymousCommand(this));
        add(new ExitAnonymousCommand());
        add(new SearchAnonymousCommand());
        add(new SearchingAnonymousCommand());
        add(new AbandonChatAnonymousCommand());
    }
}
