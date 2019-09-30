package handlers.telegram;

import core.PlatformType;
import core.User;
import handlers.BaseHandler;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class TelegramBot extends TelegramLongPollingBot
{
    private BaseHandler handler;

    public TelegramBot(BaseHandler handler)
    {
        this.handler = handler;
    }

    @Override
    public void onUpdateReceived(Update update)
    {
        Message message = update.getMessage();
        if (message != null && message.hasText() && message.isUserMessage())
        {
            var user = new User<>(message.getChatId(), PlatformType.Telegram);
            handler.handleMessage(new core.Message(message.getText(), user));
        }
    }

    public void sendMessage(core.Message message)
    {
        SendMessage send = new SendMessage();
        send.setText(message.text);
        send.setChatId((Long) message.user.getId());
        try
        {
            execute(send);
        } catch (TelegramApiException e)
        {
            System.out.println("Cant send message");
        }
    }

    @Override
    public String getBotUsername()
    {
        return TelegramData.TelegramName;
    }

    @Override
    public String getBotToken()
    {
        return TelegramData.TelegramToken;
    }
}
