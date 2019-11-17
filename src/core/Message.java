package core;

import org.telegram.telegrambots.meta.api.objects.Audio;
import org.telegram.telegrambots.meta.api.objects.PhotoSize;
import org.telegram.telegrambots.meta.api.objects.games.Animation;

import java.util.ArrayList;
import java.util.List;

public class Message
{
    //TODO:Make private add chanaling changing
    public Animation animation;
    public Audio audio;
    public String text;
    public Id id;
    public String nickName;
    public List<PhotoSize> photo;
    public ArrayList<String> buttons;

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
        if (telegramMessage.hasPhoto())
            this.photo = telegramMessage.getPhoto();
        if (telegramMessage.hasAudio())
            this.audio = telegramMessage.getAudio();
        if (telegramMessage.hasAnimation())
            this.animation = telegramMessage.getAnimation();
    }

    public boolean hasPhoto()
    {
        return photo == null;
    }

    public boolean hasAudio()
    {
        return audio == null;
    }

    public boolean hasAnimation()
    {
        return animation == null;
    }

    public boolean hasText()
    {
        return text == null;
    }
}
