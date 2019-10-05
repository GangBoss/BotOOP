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
    private ArrayList<User> users = new ArrayList<>();
    private AnonymousCommandSet commands = new AnonymousCommandSet();
    private MessageHandler bot;
    public Searcher searcher;


    public Anonymous(MessageHandler bot)
    {
        type = FunctionType.Anonymous;
        this.bot = bot;
        this.searcher = new Searcher(bot);
    }

    @Override
    public void start(User user)
    {
        if (!users.contains(user)) users.add(user);
        searcher.addUser(user);
        sendMessage(new Message("Hello, you start anonymous. say /search to find chatmate users in db:" + users.size(), user));
        user.state = FunctionType.Anonymous;
    }

    @Override
    public void stop(User user)
    {
        sendMessage(new Message("You are living anonymous chat", user));
        searcher.stop(user);
        user.state = FunctionType.None;
    }

    @Override
    public void sendMessage(Message message)
    {
        bot.sendMessage(message);
    }

    @Override
    public void handleMessage(Message message)
    {
        var user = UserDatabase.getUser(message.id);
        if (commands.hasItem(message.text))
            commands.find(message.text).execute(this, user);
        else searcher.handleMessage(message);
    }
}
