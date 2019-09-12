package core;

public interface MessageHandler
{
    public void sendMessage(String message, User user);

    public void handleMessage(String message, User user);
}
