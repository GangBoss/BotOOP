package core;

public interface Command
{
    void execute(MessageHandlable bot, User user);
}
