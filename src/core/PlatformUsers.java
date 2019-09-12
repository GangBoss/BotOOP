package core;

import java.util.HashMap;

public class PlatformUsers<T extends Comparable> extends HashMap
{
    private String userPlatform;
    private Class<T> idClass;
    private HashMap<T, User<T>> users;

    public PlatformUsers(String platform, Class<T> platformIdClass)
    {
        users = new HashMap<>();
        userPlatform = platform;
        idClass = platformIdClass;
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
        if (user.idClass != idClass)
            throw new IllegalArgumentException("User id classes aren't equal");
        return users.containsKey(user.id);
    }
}
