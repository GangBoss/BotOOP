package core;

import data.user.UserDatabase;

import java.util.ArrayList;
import java.util.List;

public class Message
{
    public String text;
    public Id id;
    private String photoPath;
    public List<String> buttons;

    public Message(String text, Id id)
    {
        this.text = text;
        this.id = id;
    }

    public Message(String text, Id id, ArrayList<String> buttons)
    {
        this.text = text;
        this.id = id;
        this.buttons = buttons;
    }

    public Message(String text, User user)
    {
        this.text = text;
        this.id = user.getFullId();
    }

    public Message(org.telegram.telegrambots.meta.api.objects.Message telegramMessage)
    {

        this.id = new Id(telegramMessage.getChatId(), PlatformType.Telegram);
        if (telegramMessage.hasText())
            this.text = telegramMessage.getText();
    }

    public boolean hasPhoto()
    {
        return photoPath != null;
    }

    public boolean hasButtons()
    {
        return buttons != null;
    }


    public boolean hasText()
    {
        return text != null;
    }

    public User getUser()
    {
        return UserDatabase.getUser(this.id);
    }

    public String getPhotoPath()
    {
        return photoPath;
    }

    public void setPhotoPath(String path)
    {
        this.photoPath = path;
    }
}
