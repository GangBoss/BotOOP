package functions.anonymous;

import core.DataBase;
import core.Message;
import core.MessageHandler;
import core.User;
import core.BaseFunction;
import functions.FunctionType;
import functions.anonymous.commands.AnonymousCommandSet;

import java.util.List;

public class Anonymous extends BaseFunction
{
    private AnonymousCommandSet commands = new AnonymousCommandSet();
    public AnonymousSearcher searcher;
    private AnonymousButtons buttons;
    private DataBase<AnonymousState> dataBase;

    public Anonymous(MessageHandler bot)
    {
        dataBase=new DataBase<>();
        type = FunctionType.Anonymous;
        this.bot = bot;
        buttons = new AnonymousButtons(dataBase);
        this.searcher = new AnonymousSearcher(bot,dataBase);
    }

    @Override
    public void start(User user)
    {
        user.state = FunctionType.Anonymous;
        if (!dataBase.containsKey(user)) dataBase.put(user, AnonymousState.Menu);
        sendMessage(new Message("Hello, you start anonymous. say /search to find chatmate users in db:" + dataBase.count(), user));
    }

    @Override
    public void stop(User user)
    {
        user.state = FunctionType.None;
        sendMessage(new Message("You are living anonymous chat", user));
        searcher.stop(user);
    }

    @Override
    public List<String> getButtons(User user)
    {
        return buttons.getButtons(user);
    }

    @Override
    public void handleMessage(Message message)
    {
        if (message.hasText())
        {
            if (commands.hasItem(message.text))
            {
                commands.find(message.text).execute(this, message);
                return;
            }
        }
        searcher.handleMessage(message);
    }
}
