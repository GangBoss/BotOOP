package data.user;

import core.User;

import java.util.HashMap;

class PlatformUsers<T> extends HashMap
{
    private HashMap<T, User<T>> users = new HashMap<>();

    void addUser(User<T> user)
    {
        if (users.containsKey(user.getId()))
            return;
        users.put(user.getId(), user);
    }

    void removeUser(T userId)
    {
        users.remove(userId);
    }

    boolean hasUser(User user)
    {
        return users.containsKey(user.getId());
    }

    User getUser(User user)
    {
        if (hasUser(user))
            return users.get(user.getId());
        return null;
    }
}
