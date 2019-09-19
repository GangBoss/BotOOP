package games.anonymous;

import core.Bot;
import core.Message;
import core.User;
import games.BaseGame;
import games.anonymous.commands.AnonymousCommandSet;
import java.util.ArrayList;
import java.util.HashMap;

public class Anonymous extends BaseGame
{
    private ArrayList<User> data = new ArrayList<User>();
    private ArrayList<User> searchers = new ArrayList<User>();
    private HashMap<User, User> pairs = new HashMap<User, User>();
    private AnonymousCommandSet commands = new AnonymousCommandSet();
    private Bot bot;

    void addPair(User first, User second)
    {
        searchers.remove(first);
        searchers.remove(second);
        sendMessage(new Message("You find pair in a chat", first));
        sendMessage(new Message("You find pair in a chat", second));
        pairs.put(first, second);
        pairs.put(second, first);
    }

    public void abandonChat(User user)
    {
        if (pairs.containsKey(user))
        {
            var user2 = pairs.get(user);
            pairs.remove(user2);
            pairs.remove(user);
            sendMessage(new Message("Your chatmate abbadone", user2));
            sendMessage(new Message("You abbadone chat", user));
        }
    }

    public void search(User user)
    {
        searchers.add(user);
        sendMessage(new Message("You are searching a pair", user));
        if (searchers.size() >= 2)
            addPair(searchers.get(0), searchers.get(1));
    }

    public Anonymous(Bot bot)
    {
        this.bot = bot;
    }

    @Override
    public void start(User user)
    {
        if (!data.contains(user)) data.add(user);
        sendMessage(new Message("Hello, you start anonymous. say searchpair to find chatmate", user));
        user.state = "anonymous";
    }

    @Override
    public void stop(User user)
    {
        user.state = "";
        sendMessage(new Message("You are living anonymous chat", user));
        data.remove(user);
        if (searchers.contains(user)) searchers.remove(user);
        abandonChat(user);
    }

    @Override
    public void sendMessage(Message message)
    {
        bot.sendMessage(message);
    }

    @Override
    public void handleMessage(Message message)
    {
        if (commands.hasCommand(message.text))
            commands.find(message.text).execute(this, message.user);
        else if (pairs.containsKey(message.user))
            sendMessage(new Message(message.text, pairs.get(message.user)));
        else
            sendMessage(new Message("It is not a command and u are not in anonymous chat yet", message.user));
    }
}
