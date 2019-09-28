package handlers;

import core.MessageHandler;
import core.PlatformType;
import core.Runner;

public abstract class BaseHandler extends Runner implements MessageHandler
{
    protected PlatformType type;

    public PlatformType getType()
    {
        return type;
    }
}
