package handlers;

import core.Bot;

import java.util.Collection;
import java.util.LinkedHashMap;

public class HandlerSet
{
    private LinkedHashMap<String, BaseHandler> handlers = new LinkedHashMap<String, BaseHandler>();

    public HandlerSet(Bot bot, boolean withUser)
    {
        //Should be last always
        if (withUser) add(new ConsoleHandler(bot));
    }

    private void add(BaseHandler handler)
    {
        Class<?> enclosingClass = handler.getClass().getEnclosingClass();
        String name;
        if (enclosingClass != null)
            name = enclosingClass.getSimpleName().toLowerCase();
        else name = handler.getClass().getSimpleName().toLowerCase();
        name = name.substring(0, name.length() - 7);
        handlers.put(name, handler);
    }

    public void start()
    {
        for (var handler : handlers.values())
            handler.start();
    }

    public void stop()
    {
        for (var handler : handlers.values())
            handler.stop();
    }

    public BaseHandler find(String name)
    {
        return handlers.getOrDefault(name, null);
    }

    public boolean hasCommand(String name)
    {
        return handlers.containsKey(name);
    }

    public Collection<BaseHandler> getAll()
    {
        return handlers.values();
    }
}
