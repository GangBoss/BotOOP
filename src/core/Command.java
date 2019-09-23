package core;

public interface Command
{
    void execute(MessageHandleable bot, User user);
}
