package functions;

import core.MessageHandler;
import core.User;

public abstract class BaseFunction implements MessageHandler
{
    protected FunctionType type;

    public FunctionType getType(){
        return type;
    }

    public abstract void start(User user);

    public abstract void stop(User user);
}
