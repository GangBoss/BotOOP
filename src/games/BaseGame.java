package games;

import core.MessageHandlable;
import core.User;

public abstract class BaseGame implements MessageHandlable
{
    public abstract void start(User user);

    public abstract void stop(User user);
}
