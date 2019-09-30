package core;

import data.botCommands.BotCommandSet;
import data.user.UserDatabase;
import functions.FunctionSet;
import functions.FunctionType;
import handlers.HandlerSet;

import java.util.concurrent.ConcurrentLinkedDeque;

public class Bot extends Runner implements MessageHandler
{
    private BotCommandSet commands = new BotCommandSet();
    private UserDatabase database = new UserDatabase();
    private ConcurrentLinkedDeque<Message> messageQueue = new ConcurrentLinkedDeque<>();
    private HandlerSet handlers;
    private FunctionSet games;
    private Thread handleThread;

    public Bot(boolean withUser) throws Exception
    {
        handlers = new HandlerSet(this, withUser);
        games = new FunctionSet(this);
        handleThread = new Thread(this::handleDeque);
    }

    public void start()
    {
        if (!isStopped)
            return;
        isStopped = false;
        System.out.println("Starting...");
        handleThread.start();
        System.out.println("Started!");
        handlers.start();
    }

    public void stop()
    {
        if (isStopped)
            return;
        isStopped = true;
        System.out.println("Stopping... May take long time.");
        handlers.stop();
        if (handleThread.isAlive())
        {
            try
            {
                handleThread.wait();
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        System.out.println("Stopped!");
    }

    @Override
    public void sendMessage(Message message)
    {
        handlers.find(message.user.getUserPlatform()).sendMessage(message);
    }

    public synchronized void addMessageToHandle(Message message)
    {
        messageQueue.add(message);
        this.notify();
    }

    private synchronized void handleDeque()
    {
        while (!isStopped)
        {
            while (messageQueue.isEmpty())
            {
                try
                {
                    this.wait();
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
            while (!messageQueue.isEmpty())
                handleMessage(messageQueue.poll());
        }
    }

    @Override
    public void handleMessage(Message message)
    {
        message.text = message.text.toLowerCase();

        if (database.hasUser(message.user))
            message.user = database.getUser(message.user);
        else database.addUser(message.user);

        if (message.user.state != FunctionType.None)
            games.find(message.user.state).handleMessage(message);

        else if (commands.hasItem(message.text))
        {
            commands.find(message.text).execute(this, message.user);
        } else sendMessage(new Message("Invalid command", message.user));
    }

    public void startGame(User user, FunctionType type)
    {
        if (games.hasItem(type))
            games.find(type).start(user);
    }
}
