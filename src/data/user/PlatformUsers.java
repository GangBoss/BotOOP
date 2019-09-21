package data.user;

import core.User;

import java.util.HashMap;

public class PlatformUsers<T> extends HashMap
{
    private String userPlatform;
    private HashMap<T, User<T>> users = new HashMap<>();

    public PlatformUsers(String platform)
    {
        userPlatform = platform;
    }

    public String getUserPlatform()
    {
        return userPlatform;
    }

    public void addUser(User<T> user)
    {
        users.put(user.id, user);
    }

    public void removeUser(T userId)
    {
        users.remove(userId);
    }

    public boolean hasUser(User user) throws IllegalArgumentException
    {
        return users.containsKey(user.id);
    }

    public User getUser(User user)
    {
        return users.get(user.id);
    }
}
