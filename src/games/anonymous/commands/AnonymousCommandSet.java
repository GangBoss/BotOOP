package games.anonymous.commands;

import core.BasicSet;
import core.CommandBase;

import java.util.HashMap;

public class AnonymousCommandSet extends BasicSet<CommandBase, HashMap<String, CommandBase>>
{
    public AnonymousCommandSet()
    {
        set = new HashMap<>();
        suffixCount = "AnonymousCommand".length();
        prefixCount=0;
        commandPrefix = "/";

        add(new ExitAnonymousCommand());
        add(new SearchAnonymousCommand());
        add(new AbandonChatAnonymousCommand());
    }
}
