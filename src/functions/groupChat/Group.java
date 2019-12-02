package functions.groupChat;

import core.Id;
import core.Message;
import core.MessageHandler;
import core.User;

import java.util.ArrayList;
import java.util.Arrays;

import static java.util.Arrays.asList;

public class Group
{
    MessageHandler bot;
    private ArrayList<User> users;

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

    public ArrayList<User> getUsers()
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

    public void sendToGroup(Message message, boolean withCurrentUser)
    {
        var currentUser = message.id;
        users
                // .stream()
                // .filter(u -> isOnline(u)).collect(Collectors.toList())
                .forEach(user ->
                {
                    message.id = user.getFullId();
                    if (withCurrentUser || !message.id.equals(currentUser))
                        bot.sendMessage(message);
                });
    }

    public void sendToGroup(Message message)
    {
        sendToGroup(message, false);
    }

    int getCount(Message message)
    {
        return users.size();
    }
}
