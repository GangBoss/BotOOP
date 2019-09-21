package data.user;

import core.User;

import java.util.HashMap;

class PlatformUsers<T> extends HashMap
{
    public final String userPlatform;
    private HashMap<T, User<T>> users = new HashMap<>();

    PlatformUsers(String platform)
    {
        userPlatform = platform;
    }

    void addUser(User<T> user)
    {
        if (users.containsKey(user.id))
            return;
        users.put(user.id, user);
    }

    void removeUser(T userId)
    {
        users.remove(userId);
    }

    boolean hasUser(User user) throws IllegalArgumentException
    {
        return users.containsKey(user.id);
    }

    User getUser(User user)
    {
        if (hasUser(user))
            return users.get(user.id);
        return null;
    }
}
