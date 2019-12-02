package core;

public interface Command<T extends MessageHandler>
{
    //TODO change User to Message
    void execute(T bot, Message message);
}
