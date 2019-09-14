package core;

import data.BotCommandSet;
import games.GameSet;
import data.user.UserDatabase;
import handlers.HandlerSet;

public class Bot implements MessageHandlable
{
    private BotCommandSet commands = new BotCommandSet();
    private UserDatabase database = new UserDatabase();
    private HandlerSet handlers;
    public final GameSet games;
    private boolean isStopped = true;
    private boolean withUser;

    public boolean getIsStopped()
    {
        return isStopped;
    }

    public Bot(boolean withUser) throws Exception
    {
        this.withUser = withUser;
        handlers = new HandlerSet(this, withUser);
        games = new GameSet(this);
    }

    public void start()
    {
        isStopped = false;
        handlers.start();
        if (withUser) stop();
    }

    public void stop()
    {
        isStopped = true;
        handlers.stop();
    }

    @Override
    public void sendMessage(String message, User user)
    {
        handlers.find(user.userPlatform).sendMessage(message, user);
    }

    @Override
    public void handleMessage(String message, User user)
    {
        message = message.toLowerCase();
        if (database.hasUser(user)) user = database.getUser(user);
        database.addUser(user);
        if (user.state != null && !user.state.isEmpty())
            games.find(user.state).handleMessage(message, user);

        else if (commands.hasCommand(message))
            commands.find(message).execute(this, user);
        else sendMessage("Invalid command", user);
    }
}
