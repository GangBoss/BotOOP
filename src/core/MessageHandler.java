package core;

public interface MessageHandler
{
    public void sendMessage(String message, int idUser);

    public void handleMessage(String message, int idUser);
}
