package handlers.telegram;

import core.Bot;
import core.Message;
import core.PlatformType;
import handlers.BaseHandler;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.BotSession;

public class TelegramHandler extends BaseHandler
{
    private Bot bot;
    private TelegramBot telegramBot;
    private BotSession session;

    public TelegramHandler(Bot bot)
    {
        ApiContextInitializer.init();
        this.bot = bot;
        type = PlatformType.Telegram;
    }

    @Override
    public void sendMessage(Message message)
    {
        telegramBot.sendMessage(message);
    }

    @Override
    public void handleMessage(Message message)
    {
        bot.addMessageToHandle(message);
    }

    @Override
    public void start()
    {
        TelegramBotsApi tBot = new TelegramBotsApi();
        try
        {
            telegramBot = new TelegramBot(this);
            session = tBot.registerBot(telegramBot);
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
