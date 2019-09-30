package functions.anonymous.commands;

import core.set.CommandSet;

import java.util.HashMap;

public class AnonymousCommandSet extends CommandSet
{
    public AnonymousCommandSet()
    {
        super(0,16,"/");

        add(new ExitAnonymousCommand());
        add(new SearchAnonymousCommand());
        add(new SearchingAnonymousCommand());
        add(new AbandonChatAnonymousCommand());
    }
}
