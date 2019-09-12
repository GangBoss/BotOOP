package core;

public class User<T extends Comparable>
{
    public Class<T> idClass;
    public T id;
    public String state;
    public String userPlatform;

    public User(T id, String userPlatform, Class<T> idClass)
    {
        this.id = id;
        this.userPlatform = userPlatform;
        this.idClass = idClass;
    }
}
