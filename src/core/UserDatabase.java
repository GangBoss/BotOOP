package core;

import java.util.HashMap;

public class UserDatabase
{
    HashMap<String, PlatformUsers> platforms;

    public boolean HasUser(String platform, User user)
    {
         platforms.get(user.id).hasUser(user);
         return true;
    }

    public void addUser(User user)
    {
       platforms.get(user.userPlatform).addUser(user);
    }

    public void removeUser(User user)
    {
        platforms.get(user.userPlatform).removeUser(user.id);
    }
}
