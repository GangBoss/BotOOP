package core;

public abstract class Runner
{
    protected boolean isStoped = true;

    public boolean getIsStoped()
    {
        return isStoped;
    }

    public abstract void start();

    public abstract void stop();
}
