package gamesTest;

import core.Message;
import core.User;
import games.anonymous.Anonymous;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import testHelpers.TestMessageHandler;

import static org.junit.Assert.*;

public class AnonymousTest
{
    private Anonymous anonymous;
    private TestMessageHandler tester;
    private User<String> user1;
    private User<String> user2;

    @Before
    public void setUp() throws Exception
    {
        user1 = new User<>("user1", "console");
        user2 = new User<>("user2", "console");
        tester = new TestMessageHandler();
        anonymous = new Anonymous(tester);
        tester.setTestedHandler(anonymous);
    }

    @Test
    public void SearchTwiceAnonymousTest()
    {
        anonymous.start(user1);
        anonymous.start(user2);
        tester.handleMessage( new Message("/search", user1));
        tester.handleMessage( new Message("/search", user1));
        tester.handleMessage( new Message("/search", user2));
        Assert.assertEquals(7, tester.queue.size());
    }

    @Test
    public void SearchersAnonymousTest()
    {
        anonymous.start(user1);
        anonymous.start(user2);
        tester.handleMessage( new Message("/search", user1));
        tester.handleMessage( new Message("/searchers", user1));
        tester.handleMessage( new Message("/search", user2));
        Assert.assertEquals(7, tester.queue.size());
    }

    @Test
    public void StartOneUserAnonymousTest()
    {
        anonymous.start(user1);
        Assert.assertEquals(1, tester.queue.size());
        Assert.assertEquals("anonymous", user1.state);
    }

    @Test
    public void StartTwoUserAnonymousTest()
    {
        anonymous.start(user1);
        anonymous.start(user2);
        Assert.assertEquals(2, tester.queue.size());
        Assert.assertEquals("anonymous", user1.state);
        Assert.assertEquals("anonymous", user2.state);
    }

    @Test
    public void StopAnonymousTest()
    {
        anonymous.start(user1);
        anonymous.stop(user1);
        Assert.assertEquals("", user1.state);
    }

    @Test
    public void ExitAnonymousTest()
    {
        anonymous.start(user1);
        Message message = new Message("/exit", user1);
        tester.handleMessage(message);
        Assert.assertEquals("", user1.state);
    }

    @Test
    public void AbandonAnonymousTest()
    {
        anonymous.start(user1);
        anonymous.start(user2);
        tester.handleMessage( new Message("/search", user1));
        tester.handleMessage( new Message("/search", user2));
        tester.handleMessage( new Message("/abandonchat", user1));
        tester.handleMessage( new Message("/abandonchat", user2));
        Assert.assertEquals(8, tester.queue.size());
    }

    @Test
    public void NotCommandAnonymousTest()
    {
        anonymous.start(user1);
        Message message = new Message("test", user1);
        tester.handleMessage(message);
        Assert.assertEquals(2, tester.queue.size());
    }
}

