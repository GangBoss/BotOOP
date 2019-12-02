package functions.anonymous;

import core.Message;
import core.MessageHandler;
import core.User;
import data.user.UserDatabase;
import functions.groupChat.GroupChat;
import functions.groupChat.Group;

import javax.swing.*;
import java.util.*;

public class AnonymousSearcher
{
    private ArrayList<User> data = new ArrayList<>();
    private ArrayDeque<User> searchers;
    private GroupChat groupChat;
    private MessageHandler bot;

    AnonymousSearcher(MessageHandler bot)
    {
        this.bot = bot;
        this.groupChat = new GroupChat(bot);
        this.searchers = new ArrayDeque<>();
    }

    public void stop(User user)
    {
        searchers.remove(user);
        abandonChat(user);
        AnonymousDataBase.states.remove(user);
    }

    public void searching(User user)
    {
        bot.sendMessage(new Message("Now searching:" + searchers.size(), user));
    }

    public void abandonChat(User user)
    {
        var userState = AnonymousDataBase.states.get(user);
        if (userState == AnonymousState.InPair)
        {
            var group = groupChat.getGroup(user);
            groupChat.abandonGroup(user);
            group.sendToGroup(new Message("Now you are alone in chat, you can use /abandonechat to live group", user));
            AnonymousDataBase.states.put(user, AnonymousState.Menu);
        } else if (userState == AnonymousState.Searching)
        {
            bot.sendMessage(new Message("You are not searching anymore", user));
            searchers.remove(user);
        }
    }

    public void search(User user)
    {
        var count = 2;
        var userState = AnonymousDataBase.states.get(user);
        if (userState == AnonymousState.Menu)
        {
            searchers.push(user);
            AnonymousDataBase.states.put(user, AnonymousState.Searching);
            bot.sendMessage(new Message("You are searching a pair  searchers: " + searchers.size(), user));
            if (searchers.size() >= count)
            {
                var group = getUserGroup(searchers, count);
                for (var u:group)
                {
                    AnonymousDataBase.states.put(u, AnonymousState.InPair);
                }

               var curGroup= groupChat.addGroup(group);
                curGroup.sendToGroup(new Message("You find pair in a chat",user),true);
            }
        } else
            bot.sendMessage(new Message("You already in pair or searching:", user));
    }

    private User[] getUserGroup(ArrayDeque<User> searchers, int count)
    {
        User[] users = new User[count];
        for (var i = 0; i < count; i++)
            users[i] = searchers.pop();
        return users;
    }


    public void handleMessage(Message message)
    {
        var user = UserDatabase.getUser(message.id);
        var userState = AnonymousDataBase.states.get(user);

        if (userState == AnonymousState.InPair)
            groupChat.handleMessage(message);
        else if (userState == AnonymousState.Searching)
            bot.sendMessage(new Message("You still Searching a chatmate", message.id));
        else
            bot.sendMessage(new Message("It is not a command and u are not in anonymous chat yet", message.id));
    }
}
