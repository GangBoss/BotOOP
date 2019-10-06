package handlers.telegram;

import core.PlatformType;
import core.User;
import handlers.BaseHandler;
import org.json.JSONObject;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TelegramBot extends TelegramLongPollingBot
{
    private BaseHandler handler;
    private String username;
    private String token;

    public TelegramBot(BaseHandler handler)
    {
        this.handler = handler;
        var path = Paths.get(System.getProperty("user.dir") + "\\res\\Settings.json");
        try
        {
            var object = new JSONObject(Files.readString(path));
            var telegram = object.getJSONObject("telegram");
            username = telegram.getString("username");
            token  = telegram.getString("token");

        } catch (IOException e)
        {
            e.getMessage();
        }
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
        send.setChatId((Long) message.id.getId());
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
        return username;
    }

    @Override
    public String getBotToken()
    {
        return token;
    }
}
