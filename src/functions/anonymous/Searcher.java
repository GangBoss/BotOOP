package functions.anonymous;

import core.Message;
import core.MessageHandler;
import core.User;
import data.user.UserDatabase;

import java.util.ArrayList;
import java.util.HashMap;

public class Searcher
{
    private ArrayList<User> data = new ArrayList<>();
    private ArrayList<User> searchers = new ArrayList<>();
    private HashMap<User, User> pairs = new HashMap<>();
    private MessageHandler bot;

    public Searcher(MessageHandler bot)
    {
        this.bot = bot;
    }

    public void addUser(User user)
    {
        data.add(user);
    }

    public void stop(User user)
    {
        searchers.remove(user);
        abandonChat(user);
    }

    public void searching(User user)
    {
        bot.sendMessage(new Message("Now searching:" + searchers.size(), user));
    }


    private void addPair(User first, User second)
    {
        searchers.remove(first);
        searchers.remove(second);
        bot.sendMessage(new Message("You find pair in a chat", first));
        bot.sendMessage(new Message("You find pair in a chat", second));
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
            bot.sendMessage(new Message("Your chatmate abandon chat", user2));
            bot.sendMessage(new Message("You abandon chat", user));
        } else if (searchers.contains(user))
        {
            bot.sendMessage(new Message("You are not searching anymore", user));
            searchers.remove(user);
        }
    }

    public void search(User user)
    {
        if (!pairs.containsKey(user) && !searchers.contains(user))
        {
            searchers.add(user);
            bot.sendMessage(new Message("You are searching a pair  searchers:" + searchers.size(), user));
            if (searchers.size() >= 2)
                addPair(searchers.get(0), searchers.get(1));
        } else bot.sendMessage(new Message("You already in pair or searching:", user));
    }

    public void handleMessage(Message message)
    {
        var user = UserDatabase.getUser(message.id);
        if (pairs.containsKey(user))
            bot.sendMessage(new Message(message.text, pairs.get(user)));
        else if (searchers.contains(user))
            bot.sendMessage(new Message("You still Searching a chatmate", message.id));
        else
            bot.sendMessage(new Message("It is not a command and u are not in anonymous chat yet", message.id));
    }
}
