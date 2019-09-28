package games.anonymous.commands;

import core.CommandBase;
import core.set.StringSet;

import java.util.HashMap;

public class AnonymousCommandSet extends StringSet<CommandBase>
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
