package functions.groupChat;

import core.Message;
import core.MessageHandler;
import core.User;
import data.user.UserDatabase;
import handlers.BaseHandler;

import java.util.ArrayList;
import java.util.HashMap;


public class GroupChat
{
    private MessageHandler bot;
    private ArrayList<Group> groups;
    private HashMap<User,Group> online;

    public GroupChat(MessageHandler bot){
        this.bot=bot;
        groups=new ArrayList<>();
        online=new HashMap<>();
    }

    public void abandonGroup(User user)
    {
        var group=online.get(user);
        group.abandonGroup(user);
        online.remove(user);

    }

    public void handleMessage(Message message)
    {
        var user=UserDatabase.getUser(message.id);
        var group=online.get(user);
            group.sendToGroup(message);
    }


    public Group addGroup(User[] users){
        var group=new Group(bot,users);
        groups.add(group);
        for (var user:users)
        {
            online.put(user,group);
        }
        return  group;
    }
    public Group getGroup(User user)
    {
        return online.get(user);

    }

}
