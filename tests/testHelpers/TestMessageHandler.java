package testHelpers;

import core.Message;
import core.MessageHandler;

import java.util.ArrayDeque;

public class TestMessageHandler implements MessageHandler
{
    private MessageHandler handler;
    public ArrayDeque<Message> queue = new ArrayDeque<>();

    public void setTestedHandler(MessageHandler testedHandler)
    {
        handler = testedHandler;
    }

    @Override
    public void sendMessage(Message message)
    {
        queue.push(message);
    }

    @Override
    public void handleMessage(Message message)
    {
        handler.handleMessage(message);
    }
}
