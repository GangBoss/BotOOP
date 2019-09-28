package games;

import core.MessageHandler;
import core.User;

public abstract class BaseGame implements MessageHandler
{
    public abstract void start(User user);

    public abstract void stop(User user);
}
