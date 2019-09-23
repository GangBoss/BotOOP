package games;

import core.MessageHandleable;
import core.User;

public abstract class BaseGame implements MessageHandleable
{
    public abstract void start(User user);

    public abstract void stop(User user);
}
