package data.user;

import core.PlatformType;
import core.User;

import java.util.HashMap;

public class UserDatabase
{
    private HashMap<PlatformType, PlatformUsers> platforms = new HashMap<>();

    public boolean hasUser(User user)
    {
        if (!platforms.containsKey(user.getUserPlatform())) return false;
        return platforms.get(user.getUserPlatform()).hasUser(user);
    }

    public void addUser(User user)
    {
        if (!platforms.containsKey(user.getUserPlatform()))
            platforms.put(user.getUserPlatform(), new PlatformUsers<>());
        platforms.get(user.getUserPlatform()).addUser(user);
    }

    public void removeUser(User user)
    {
        platforms.get(user.getUserPlatform()).removeUser(user.getId());
    }

    public User getUser(User user)
    {
        if (platforms.containsKey(user.getUserPlatform()))
            return platforms.get(user.getUserPlatform()).getUser(user);
        return null;
    }
}
