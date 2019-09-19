package core;

public class Message
{
    public String text;
    public User user;

    public Message(String text, User user)
    {
        this.text = text;
        this.user = user;
    }
}
