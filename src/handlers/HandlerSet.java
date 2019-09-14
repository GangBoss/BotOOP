package handlers;

import core.BasicSet;
import core.Bot;

import java.util.Collection;
import java.util.LinkedHashMap;

public class HandlerSet extends BasicSet<BaseHandler>
{

    public HandlerSet(Bot bot, boolean withUser)
    {
        prefixCount = 0;
        suffixCount = 7;
        //Should be last always
        if (withUser) add(new ConsoleHandler(bot));
    }


    public void start()
    {
        for (var handler : set.values())
            handler.start();
    }

    public void stop()
    {
        for (var handler : set.values())
            handler.stop();
    }
}
