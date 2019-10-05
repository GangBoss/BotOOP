package core;

public class Message
{
    public String text;
    public Id id;

    public Message(String text, Id id)
    {
        this.text = text;
        this.id = id;
    }

    public Message(String text, User user){
        this.text = text;
        this.id = user.getFullId();
    }
}
