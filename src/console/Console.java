package console;

import core.Bot;

import java.util.Scanner;

public class Console
{
    public static void main(String[] args) throws Exception
    {
        var withUser = false;
        var scanner = new Scanner(System.in);

        if (args.length == 0 || (!args[0].equals("n") && !args[0].equals("y") && !args[0].equals("")))
        {
            while (true)
            {
                System.out.println("Run with console user? (y/n, default:n)");
                var input = scanner.nextLine().toLowerCase();
                if (input.equals("y"))
                {
                    withUser = true;
                    break;
                } else if (input.isEmpty() || input.equals("n"))
                    break;
                else System.out.println("Invalid parameter");
            }
        }
        else withUser = !args[0].equals("n");

        Bot bot = new Bot(withUser);
        bot.start();
        if(withUser)
            return;
        while (!bot.getIsStopped())
        {
            if (scanner.nextLine().equals("exit"))
                bot.stop();
        }
    }
}
