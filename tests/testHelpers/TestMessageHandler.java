package testHelpers;

import core.Message;
import core.MessageHandleable;

import java.util.ArrayDeque;

public class TestMessageHandler implements MessageHandleable
{
    private MessageHandleable handler;
    public ArrayDeque<Message> queue = new ArrayDeque<>();

    public void setTestedHandler(MessageHandleable testedHandler)
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
