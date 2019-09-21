package data.user;

import core.User;

import java.util.HashMap;

public class UserDatabase
{
    private HashMap<String, PlatformUsers> platforms = new HashMap<>();

    public boolean hasUser(User user)
    {
        if(!platforms.containsKey(user.userPlatform)) return false;
        return platforms.get(user.userPlatform).hasUser(user);
    }

    public void addUser(User user)
    {
        if (!platforms.containsKey(user.userPlatform))
            platforms.put(user.userPlatform, new PlatformUsers<>(user.userPlatform));
        platforms.get(user.userPlatform).addUser(user);
    }

    public void removeUser(User user)
    {
        platforms.get(user.userPlatform).removeUser(user.id);
    }

    public User getUser(User user)
    {
        return platforms.get(user.userPlatform).getUser(user);
    }
}
