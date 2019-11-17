package functions;

import core.MessageHandler;
import core.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;

public abstract class BaseFunction implements MessageHandler
{
    protected FunctionType type;

    public FunctionType getType()
    {
        return type;
    }

    public abstract void start(User user);

    public abstract void stop(User user);

    public  abstract ArrayList<String> getButtons(User user);

}
