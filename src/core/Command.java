package core;

public interface Command<T extends MessageHandler>
{
    void execute(T bot, User user);
}
