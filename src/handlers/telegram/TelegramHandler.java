package handlers.telegram;

import core.Bot;
import core.Message;
import handlers.BaseHandler;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.BotSession;

public class TelegramHandler extends BaseHandler
{
    private Bot bot;
    private TelegramBot tBotHandler;
    private BotSession session;

    public TelegramHandler(Bot bot)
    {
        ApiContextInitializer.init();
        this.bot = bot;
    }

    @Override
    public void sendMessage(Message message)
    {
        tBotHandler.sendMessage(message);
    }

    @Override
    public void handleMessage(Message message)
    {
        bot.handleMessage(message);
    }

    @Override
    public void start()
    {
        TelegramBotsApi tBot = new TelegramBotsApi();
        try
        {
            tBotHandler = new TelegramBot(this);
            session = tBot.registerBot(tBotHandler);
        } catch (TelegramApiException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void stop()
    {
        session.stop();
    }
}
