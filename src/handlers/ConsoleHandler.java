package handlers;

import core.Bot;
import core.MessageHandlable;
import core.Runner;
import core.User;

import java.util.Scanner;

public class ConsoleHandler extends BaseHandler
{
    private Bot bot;

    ConsoleHandler(Bot bot)
    {
        this.bot = bot;
    }

    @Override
    public void sendMessage(String message, User user)
    {
        System.out.println(message);
    }

    @Override
    public void handleMessage(String message, User user)
    {
        bot.handleMessage(message, user);
    }

    @Override
    public void start()
    {
        isStoped = false;
        Scanner console = new Scanner(System.in);
        System.out.println("Enter your name:");
        var name = console.nextLine();

        var user = new User<>(name, "console");
        System.out.println("Enter \"list\" to view all commands.");
        while (!getIsStoped())
        {
            var input = console.nextLine();
            handleMessage(input, user);
        }
    }

    @Override
    public void stop()
    {
        isStoped = true;
    }
}
