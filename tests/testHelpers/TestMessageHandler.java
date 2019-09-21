package testHelpers;

import core.Message;
import core.MessageHandlable;

import java.util.ArrayDeque;

public class TestMessageHandler implements MessageHandlable
{
    private MessageHandlable handler;
    public ArrayDeque<Message> queue = new ArrayDeque<>();

    public void setTestedHandler(MessageHandlable testedHandler)
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
