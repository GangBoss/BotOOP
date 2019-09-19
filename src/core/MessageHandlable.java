package core;

public interface MessageHandlable
{
    void sendMessage(Message message);

    void handleMessage(Message message);
}
