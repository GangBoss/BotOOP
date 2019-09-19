package games;

import core.MessageHandlable;
import core.Runner;
import core.User;

public abstract class BaseGame extends Runner implements MessageHandlable
{
    public abstract void start(User user);

    public abstract void stop(User user);
}
