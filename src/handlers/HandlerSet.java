package handlers;

import core.Bot;
import core.PlatformType;
import core.set.BasicSet;
import handlers.telegram.TelegramHandler;

import java.util.LinkedHashMap;

public class HandlerSet extends BasicSet<PlatformType, BaseHandler>
{
    public HandlerSet(Bot bot, boolean withUser)
    {
        set = new LinkedHashMap<>();
        add(new TelegramHandler(bot));
        //Should be last always
        if (withUser) add(new ConsoleHandler(bot));
    }


    public void start()
    {
        for (var handler : set.values())
        {
            try
            {
                handler.start();
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    public void stop()
    {
        for (var handler : set.values())
            handler.stop();
    }

    @Override
    protected void add(BaseHandler item)
    {
        set.put(item.getType(), item);
    }
}
