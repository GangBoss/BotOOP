package functions.anonymous.groupChat;

import core.Id;
import core.Message;
import core.MessageHandler;
import core.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

public class Group
{
    MessageHandler bot;
    private List<User> users;

    Group(MessageHandler bot, User[] users)
    {
        this.users = new ArrayList<>(Arrays.asList(users));
        this.bot = bot;
    }


    public void addUser(User user)
    {
        users.add(user);
        sendToGroup(new Message("New user now in chat", user));
    }

    public List<User> getUsers()
    {
        return users;
    }

    public void sendMessage(Message message)
    {
        bot.sendMessage(message);
    }

    void abandonGroup(User user)
    {
        users.remove(user);
        sendToGroup(new Message("User disconected", user));
    }

    public void sendToGroup(Message message)
    {
        var currentUser = message.id;
        users.forEach(user ->
        {
            message.id = user.getFullId();
            if ( !message.id.equals(currentUser))
                bot.sendMessage(message);
        });
    }

    public void sendToAllGroup(Message message)
    {
        bot.sendMessage(message);
        sendToGroup(message);
    }

    int getCount(Message message)
    {
        return users.size();
    }
}
