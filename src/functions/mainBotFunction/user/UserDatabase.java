package data.user;

import core.Id;
import core.PlatformType;
import core.User;

import java.util.HashMap;

public abstract class UserDatabase
{
    private static HashMap<PlatformType, PlatformUsers> platforms = new HashMap<>();

    public static boolean hasUser(User user)
    {
        if (!platforms.containsKey(user.getUserPlatform())) return false;
        return platforms.get(user.getUserPlatform()).hasUser(user);
    }

    public static boolean hasUser(Id id){
        if (!platforms.containsKey(id.getUserPlatform())) return false;
        return platforms.get(id.getUserPlatform()).hasUser(id);
    }

    public static void addUser(User user)
    {
        if (!platforms.containsKey(user.getUserPlatform()))
            platforms.put(user.getUserPlatform(), new PlatformUsers<>());
        platforms.get(user.getUserPlatform()).addUser(user);
    }

    public static User addUser(Id id){
        if (!platforms.containsKey(id.getUserPlatform()))
            platforms.put(id.getUserPlatform(), new PlatformUsers<>());
        return platforms.get(id.getUserPlatform()).addUser(id);
    }

    public static void removeUser(User user)
    {
        platforms.get(user.getUserPlatform()).removeUser(user.getId());
    }

    public static User getUser(User user)
    {
        if (platforms.containsKey(user.getUserPlatform()))
            return platforms.get(user.getUserPlatform()).getUser(user);
        return null;
    }

    public static User getUser(Id id)
    {
        if (platforms.containsKey(id.getUserPlatform()))
            return platforms.get(id.getUserPlatform()).getUser(id);
        return null;
    }

    public static void clear(){
        platforms.clear();
    }
}
