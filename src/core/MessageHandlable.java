package core;

public interface MessageHandlable
{
    void sendMessage(String message, User user);

    void handleMessage(String message, User user);
}
