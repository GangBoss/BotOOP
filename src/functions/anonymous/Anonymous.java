package functions.anonymous;

import core.Message;
import core.MessageHandler;
import core.User;
import data.user.UserDatabase;
import functions.BaseFunction;
import functions.FunctionType;
import functions.anonymous.commands.AnonymousCommandSet;

import java.util.ArrayList;

public class Anonymous extends BaseFunction
{
    private AnonymousCommandSet commands = new AnonymousCommandSet();
    private MessageHandler bot;
    public AnonymousSearcher searcher;
    private AnonymousButtons buttons;

    public Anonymous(MessageHandler bot)
    {
        buttons = new AnonymousButtons();
        type = FunctionType.Anonymous;
        this.bot = bot;
        this.searcher = new AnonymousSearcher(bot);

    }

    @Override
    public void start(User user)
    {
        user.state = FunctionType.Anonymous;
        if (!AnonymousDataBase.states.containsKey(user)) AnonymousDataBase.states.put(user, AnonymousState.Menu);
        sendMessage(new Message("Hello, you start anonymous. say /search to find chatmate users in db:" + AnonymousDataBase.states.size(), user));
    }

    @Override
    public void stop(User user)
    {
        user.state = FunctionType.None;
        sendMessage(new Message("You are living anonymous chat", user));
        searcher.stop(user);
    }

    @Override
    public ArrayList<String> getButtons(User user)
    {
        return buttons.getButtons(user);
    }

    @Override
    public void sendMessage(Message message)
    {
        bot.sendMessage(message);
    }

    @Override
    public void handleMessage(Message message)
    {
        if (message.hasText())
        {
            if (commands.hasItem(message.text))
            {
                commands.find(message.text).execute(this, message);
                return;
            }
        }
        searcher.handleMessage(message);
    }
}
