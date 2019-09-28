package core;

public interface Command
{
    void execute(MessageHandler bot, User user);
}
