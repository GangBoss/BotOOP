package core;


import java.util.ArrayList;

public abstract class CommandBase<T extends MessageHandler> implements Command<T>
{
    public String info;
    protected ArrayList<PlatformType> includingPlatforms = new ArrayList<>();

    public boolean hasIncludingPlatform(PlatformType platform)
    {
        return includingPlatforms.size() != 0 && !includingPlatforms.contains(platform);
    }

    public CommandBase(String info)
    {
        this.info = info;
    }
}
