package core;

public interface MessageHandleable
{
    void sendMessage(Message message);

    void handleMessage(Message message);
}
