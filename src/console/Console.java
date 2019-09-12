package console;

import core.Bot;
import core.PlatformUsers;
import core.User;

import java.util.Scanner;

public class Console
{
    public static void main(String[] args)
    {
        var bot = new Bot();
        var scanner = new Scanner(System.in);
        User<Comparable> user;

        System.out.println("Enter your name:");
        var name = scanner.nextLine();
        if (!bot.haveUser(name, "Console"))
        {
            bot.addUser(name, "Console");
        }

        System.out.println(String.format("Hello %s.", name));
        System.out.println("enter help to show command list.");
        while (true)
        {


        }
    }
}
