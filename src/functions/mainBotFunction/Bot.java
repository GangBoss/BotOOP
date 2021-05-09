package core;

import data.botCommands.BotCommandSet;
import data.user.UserDatabase;
import functions.FunctionSet;
import functions.FunctionType;
import handlers.HandlerSet;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;


public class Bot extends Runner implements MessageHandler
{
    private BotCommandSet commands = new BotCommandSet();
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

    public void startGame(User user, FunctionType type)
    {
        if (games.hasItem(type))
            games.find(type).start(user);
    }

    public synchronized void addMessageToHandle(Message message)
    {
        messageQueue.add(message);
        this.notify();
    }

    @Override
    public void sendMessage(Message message)
    {
        var user = message.getUser();
        if (user.state == FunctionType.None)
            message.buttons = getDefaultButtons(user);
        handlers.find(message.id.getUserPlatform()).sendMessage(message);
    }

    @Override
    public void handleMessage(Message message)
    {
        message.text = message.text.toLowerCase();
        User user;
        if (UserDatabase.hasUser(message.id))
            user = UserDatabase.getUser(message.id);
        else user = UserDatabase.addUser(message.id);

        if (user.state != FunctionType.None)
            games.find(user.state).handleMessage(message);

        else if (commands.hasItem(message.text))
        {
            commands.find(message.text).execute(this, message);
        } else sendMessage(new Message("Invalid command", message.id));
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

    private List<String> getDefaultButtons(User user)
    {
        return Arrays.asList(
                "/quiz",
                "/anonymous",
                "/list");
    }
}

