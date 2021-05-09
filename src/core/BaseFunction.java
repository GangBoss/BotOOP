package core;

import core.Message;
import core.MessageHandler;
import core.User;
import data.user.UserDatabase;
import functions.FunctionType;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class BaseFunction implements MessageHandler
{
    protected MessageHandler bot;
    public FunctionType type;

    public FunctionType getType()
    {
        return type;
    }

    public abstract void start(User user);

    public abstract void stop(User user);

    @Override
    public void sendMessage(Message message)
    {
        message.buttons = getButtons(Objects.requireNonNull(UserDatabase.getUser(message.id)));
        bot.sendMessage(message);
    }
    public  abstract List<String> getButtons(User user);


}
