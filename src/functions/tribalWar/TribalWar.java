package functions.tribalWar;

import core.Message;
import core.MessageHandler;
import core.Updatable;
import core.User;
import data.user.UserDatabase;
import functions.BaseFunction;
import functions.FunctionType;
import functions.tribalWar.VillageConfiguration.Village;
import functions.tribalWar.VillageConfiguration.VillageDay;
import functions.tribalWar.commands.TribalWarCommandSet;

import java.util.List;
import java.util.Random;

public class TribalWar extends BaseFunction implements Updatable
{
    private TribalWarCommandSet commands = new TribalWarCommandSet();
    private TribalWarButtons buttons;
    private TribalWarDataBase dataBase;
    private Random random;

    public TribalWar(MessageHandler bot)
    {
        random = new Random();
        this.bot = bot;
        dataBase = new TribalWarDataBase();
        buttons = new TribalWarButtons(dataBase);
        type = FunctionType.TribalWar;
    }

    @Override
    public void start(User user)
    {
        user.state = type;
        if (!dataBase.containsKey(user))
        {
            var village = new Village(VillageDay.getNewDay(random), Village.startVillages);
            var data = new TribalWarData(village, TribalWarState.Playing);
            dataBase.put(user, data);
        }
        var openMess = new Message("Hello, you start tribalWar. say /getInformation ", user);

        openMess.setPhotoPath(getPathToRes() + "openScreen.jpg");

        sendMessage(openMess);
    }

    @Override
    public void stop(User user)
    {
        user.state = FunctionType.None;
        sendMessage(new Message("You are living tribal war, but your progress is saved", user));
    }

    @Override
    public List<String> getButtons(User user)
    {
        return buttons.getButtons(user);
    }

    @Override
    public synchronized void update()
    {
        var day = VillageDay.getNewDay(random);
        for (var element : dataBase.data.values())
        {
            element.village.endDay(day);
        }
        for (var user : dataBase.data.keySet())
        {
            if (UserDatabase.getUser(user).state == FunctionType.TribalWar)
                sendInformation(user);
        }
    }

    @Override
    public void handleMessage(Message message)
    {
        if (message.hasText())
        {
            var command = message.text.split(" ")[0];
            if (commands.hasItem(command))
            {
                commands.find(command).execute(this, message);
                return;
            }
        }
        bot.sendMessage(new Message("Invalid command", message.getUser()));
    }

    public void hunt(User user, Integer param)
    {
        var data = dataBase.get(user);

        if (param == null || param <= 0)
            bot.sendMessage(new Message("add parametr that bigger than zero to the command", user));
        else
        {
            var sended = data.village.hunt(param);
            bot.sendMessage(new Message(sended + " of your villages were send to hunt", user));
        }
    }

    public void sendInformation(User user)
    {
        var data = dataBase.get(user);
        var text = data.village.getInformation();
        bot.sendMessage(new Message(text, user));
    }

    public void chop(User user, Integer param)
    {
        var data = dataBase.get(user);

        if (param == null || param <= 0)
            bot.sendMessage(new Message("add parametr that bigger than zero to the command", user));
        else
        {
            var sended = data.village.chop(param);
            bot.sendMessage(new Message(sended + " of your villages were send to chop", user));
        }

    }

    private String getPathToRes()
    {
        return System.getProperty("user.dir") + "\\res\\";
    }
}
