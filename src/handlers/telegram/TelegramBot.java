package handlers.telegram;

import core.PlatformType;
import core.User;
import handlers.BaseHandler;
import org.json.JSONObject;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

public class TelegramBot extends TelegramLongPollingBot
{
    private BaseHandler handler;
    private String username;
    private String token;
    private Message send;

    TelegramBot(BaseHandler handler)
    {
        this.handler = handler;
        var path = Paths.get(System.getProperty("user.dir") + "\\res\\Settings.json");
        try
        {
            var object = new JSONObject(Files.readString(path));
            var telegram = object.getJSONObject("telegram");
            username = telegram.getString("username");
            token = telegram.getString("token");

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
            var coreMess = new core.Message(message);
            handler.handleMessage(coreMess);
        }
    }

    public void sendMessage(core.Message message)
    {
        SendMessage send = convertToSendMessage(message);
        try
        {
           execute(send);
        } catch (TelegramApiException e)
        {
            System.out.println("Cant send message");
        }
        if(message.hasPhoto()){
            var path=message.getPhotoPath();
            var photo=new File(path);
            SendPhoto sendPhoto=new SendPhoto().setChatId((Long) message.id.getId()).setPhoto(photo);
            try
            {
                execute(sendPhoto);
            } catch (TelegramApiException e)
            {
                e.printStackTrace();
            }
        }



    }


    private SendMessage convertToSendMessage(core.Message message)
    {
        var send = new SendMessage();
        if (message != null)
        {
            send.setChatId((Long) message.id.getId());
            if (message.hasText())
                send.setText(message.text);
            if (!(message.buttons.isEmpty()))
            {
                var markup = new ReplyKeyboardMarkup();
                markup.setResizeKeyboard(true);
                var row = new KeyboardRow();
                row.addAll(message.buttons);
                var rows = Collections.singletonList(row);
                markup.setKeyboard(rows);
                send.setReplyMarkup(markup);
            }
        }
        return send;
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
