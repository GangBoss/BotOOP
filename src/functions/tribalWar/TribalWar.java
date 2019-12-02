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
import functions.tribalWar.VillageConfiguration.VillageState;
import functions.tribalWar.commands.TribalWarCommandSet;

import java.util.ArrayList;
import java.util.Random;

public class TribalWar extends BaseFunction implements Updatable
{
    private TribalWarCommandSet commands = new TribalWarCommandSet();
    private MessageHandler bot;
    // public TribalWarSearcher searcher;
    private TribalWarButtons buttons;

    public TribalWar(MessageHandler bot)
    {
        buttons = new TribalWarButtons();
        type = FunctionType.TribalWar;
        this.bot = bot;
        // this.searcher = new TribalWarSearcher(bot);

    }

    @Override
    public void start(User user)
    {
        user.state = type;
        if (!TribalWarDataBase.containsKey(user))
        {
            var village = new Village(VillageDay.getNewDay(new Random()), Village.startVillages);
            var data = new TribalWarData(village, TribalWarState.Playing);
            TribalWarDataBase.put(user, data);
        }
        var openMess=new Message("Hello, you start tribalWar. say /getInformation ", user);
        openMess.setPhotoPath("F:\\screen-2.jpg");
        sendMessage(openMess);
    }

    @Override
    public void stop(User user)
    {
        user.state = FunctionType.None;
        sendMessage(new Message("You are living tribal war, but your progress is saved", user));
    }

    @Override
    public ArrayList<String> getButtons(User user)
    {
        return buttons.getButtons(user);
    }

    @Override
    public void sendMessage(Message message)
    {
        bot.sendMessage(message);
    }

    @Override
    public synchronized void update()
    {
        var day = VillageDay.getNewDay(new Random());
        for (var element : TribalWarDataBase.data.values())
        {
            element.village.endDay(day);
        }
        for (var user : TribalWarDataBase.data.keySet())
        {
            getInformation(user);
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

    public void hunt(Message message)
    {
        var data = TribalWarDataBase.get(message.getUser());
        var param = getNumericParam(message.text);
        if (param == 0)
            bot.sendMessage(new Message("add parametr to the command", message.getUser()));
        else
        {
            data.village.hunt(param);
            bot.sendMessage(new Message("Some of your villages were send to hunt", message.getUser()));
        }
    }

    public void getInformation(User user)
    {
        var data = TribalWarDataBase.get(user);
        var text = data.village.getInformation();
        bot.sendMessage(  new Message(text, user));
    }

    public void chop(Message message)
    {
        var data = TribalWarDataBase.get(message.getUser());
        var param = getNumericParam(message.text);
        if (param == 0)
            bot.sendMessage(new Message("add parametr to the command", message.getUser()));
        else
        {
            data.village.chop(param);
            bot.sendMessage(new Message("Some of your villages were send to chop", message.getUser()));
        }

    }

    private int getNumericParam(String messageText)
    {
        var text = messageText.split(" ");
        try
        {
            return Integer.parseInt(text[1]);

        } catch (Exception e)
        {
            return 0;
        }
    }
    //Find room
    //start solo
    // info
}
