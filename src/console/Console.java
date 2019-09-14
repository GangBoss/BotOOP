package console;

import bot.BotStarter;
import core.Bot;
import core.User;
import games.quiz.Converter;

import java.util.Scanner;

public class Console
{
    public static void main(String[] args) throws Exception
    {
        var scanner = new Scanner(System.in);
        while (true)
        {
            System.out.println("Run with console user? (y/n, default:n)");
            var input = scanner.nextLine().toLowerCase();
            if (input.equals("y"))
            {
                BotStarter.main(new String[]{"y"});
                break;
            } else if (input.isEmpty() || input.equals("n"))
            {
                BotStarter.main(new String[]{"n"});
                break;
            } else System.out.println("Invalid parametr");
        }
    }
}
