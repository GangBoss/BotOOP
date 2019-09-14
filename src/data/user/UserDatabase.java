package data.user;

import core.User;

import java.util.HashMap;

public class UserDatabase
{
    private HashMap<String, PlatformUsers<Comparable>> platforms = new HashMap<>();

    public boolean hasUser(User user)
    {
        if(!platforms.containsKey(user.userPlatform)) return false;
        return platforms.get(user.userPlatform).hasUser(user);
    }

    public void addUser(User<Comparable> user)
    {
        if (!platforms.containsKey(user.userPlatform))
            platforms.put(user.userPlatform, new PlatformUsers<>(user.userPlatform));
        platforms.get(user.userPlatform).addUser(user);
    }

    public void removeUser(User<Comparable> user)
    {
        platforms.get(user.userPlatform).removeUser(user.id);
    }

    public User getUser(User<Comparable> user)
    {
        return platforms.get(user.userPlatform).getUser(user);
    }
}
