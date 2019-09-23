package core;

import data.botCommands.BotCommandSet;
import games.GameSet;
import data.user.UserDatabase;
import handlers.HandlerSet;

import java.util.ArrayDeque;

public class Bot extends Runner implements MessageHandleable
{
    private BotCommandSet commands = new BotCommandSet();
    private UserDatabase database = new UserDatabase();
    private ArrayDeque<Message> messageQueue = new ArrayDeque<>();
    private HandlerSet handlers;
    public final GameSet games;
    private boolean withUser;

    public Bot(boolean withUser) throws Exception
    {
        this.withUser = withUser;
        handlers = new HandlerSet(this, withUser);
        games = new GameSet(this);
    }

    public void start()
    {
        if (!isStopped)
            return;
        isStopped = false;
        handlers.start();
    }

    public void stop()
    {
        if (isStopped)
            return;
        isStopped = true;
        System.out.println("Stopping...");
        handlers.stop();
    }

    @Override
    public void sendMessage(Message message)
    {
        handlers.find(message.user.userPlatform).sendMessage(message);
    }

    public void AddMessageToHandle(Message message)
    {

    }

    @Override
    public void handleMessage(Message message)
    {
        message.text = message.text.toLowerCase();

        if (database.hasUser(message.user))
            message.user = database.getUser(message.user);
        else database.addUser(message.user);

        if (message.user.state != null && !message.user.state.isEmpty())
            games.find(message.user.state).handleMessage(message);

        else if (commands.hasCommand(message.text))
            commands.find(message.text).execute(this, message.user);
        else sendMessage(new Message("Invalid command", message.user));
    }
}
