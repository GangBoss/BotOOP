package data.user;

import core.Id;
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

    User addUser(Id<T> id)
    {
        if (users.containsKey(id.getId()))
            return users.get(id.getId());
        var user = new User<>(id);
        users.put(id.getId(),user);
        return user;
    }

    void removeUser(T userId)
    {
        if (users.containsKey(userId))
        users.remove(userId);
        else throw new IllegalArgumentException("User with that id not contains in database");
    }

    boolean hasUser(User user)
    {
        return users.containsKey(user.getId());
    }

    boolean hasUser(Id id){
        return users.containsKey(id.getId());
    }

    User getUser(User user)
    {
        if (hasUser(user))
            return users.get(user.getId());
        return null;
    }

    User getUser(Id<T> id)
    {
        if (hasUser(id))
            return users.get(id.getId());
        return null;
    }
}
