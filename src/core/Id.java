package core;

public class Id<T>
{
    private T id;
    private PlatformType userPlatform;

    public T getId(){
        return id;
    }

    public PlatformType getUserPlatform(){
        return userPlatform;
    }

    public Id(T id, PlatformType type){
        this.id = id;
        this.userPlatform = type;
    }

    @Override
    public int hashCode()
    {
        String res = id.toString() + userPlatform.toString();
        return res.hashCode();
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof Id)
        {
            var other = (Id<?>) obj;
            return other.id.equals(id) && other.userPlatform.equals(userPlatform);
        }
        return false;
    }
}
