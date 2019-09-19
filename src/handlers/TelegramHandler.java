package handlers;

import core.Bot;
import core.Message;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

public class TelegramHandler extends BaseHandler
{
    private Bot bot;
    private TelegramLongPollingBot telegramBot;

    public TelegramHandler(Bot bot)
    {
        this.bot = bot;
    }

    @Override
    public void sendMessage(Message message)
    {

    }

    @Override
    public void handleMessage(Message message)
    {

    }

    @Override
    public void start()
    {

    }

    @Override
    public void stop()
    {

    }
}
