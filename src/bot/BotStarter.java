package bot;

import core.Bot;

public class BotStarter
{
    public static void main(String[] args) throws Exception
    {
        if (args.length == 0 || !(args[0].equals("y") || args[0].equals("n")))
            throw new IllegalArgumentException();

        var withUser = args[0].equals("y");
        Bot bot = new Bot(withUser);
        bot.start();
        while (!bot.getIsStopped())
        {

        }
    }
}
