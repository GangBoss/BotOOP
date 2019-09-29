package games;

import core.MessageHandler;
import core.User;

public abstract class BaseGame implements MessageHandler
{
    protected GameType type;

    public GameType getType(){
        return type;
    }

    public abstract void start(User user);

    public abstract void stop(User user);
}
