package handlers;

import core.Bot;
import core.Message;
import core.PlatformType;
import core.User;

import java.util.Scanner;

public class ConsoleHandler extends BaseHandler
{
    private Bot bot;

    ConsoleHandler(Bot bot)
    {
        this.bot = bot;
        type = PlatformType.Console;
    }

    @Override
    public void sendMessage(Message message)
    {
        System.out.println(message.text);
    }

    @Override
    public void handleMessage(Message message)
    {
        bot.handleMessage(message);
    }

    @Override
    public void start()
    {
        isStopped = false;
        Scanner console = new Scanner(System.in);
        System.out.println("Enter your name:");
        var name = console.nextLine();

        var user = new User<>(name, type);
        handleMessage(new Message("/start", user));
        while (!getIsStopped())
        {
            var input = console.nextLine();
            handleMessage(new Message(input, user));
        }
    }

    @Override
    public void stop()
    {
        isStopped = true;
    }
}
