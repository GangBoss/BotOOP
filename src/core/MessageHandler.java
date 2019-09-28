package core;

public interface MessageHandler
{
    void sendMessage(Message message);

    void handleMessage(Message message);
}
