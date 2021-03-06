package gamesTest;

import core.Message;
import core.PlatformType;
import core.User;
import data.user.UserDatabase;
import functions.FunctionType;
import functions.anonymous.Anonymous;
import functions.anonymous.AnonymousDataBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import testHelpers.TestMessageHandler;

public class AnonymousTest
{
    private Anonymous anonymous;
    private TestMessageHandler tester;
    private User<String> user1;
    private User<String> user2;

    @Before
    public void setUp()
    {
        UserDatabase.clear();
        user1 = new User<>("user1", PlatformType.Console);
        user2 = new User<>("user2", PlatformType.Console);
        UserDatabase.addUser(user1);
        UserDatabase.addUser(user2);
        tester = new TestMessageHandler();
        anonymous = new Anonymous(tester);
        tester.setTestedHandler(anonymous);
       // AnonymousDataBase.states.clear();

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
        Assert.assertEquals(FunctionType.Anonymous, user1.state);
    }

    @Test
    public void StartTwoUserAnonymousTest()
    {
        anonymous.start(user1);
        anonymous.start(user2);
        Assert.assertEquals(2, tester.queue.size());
        Assert.assertEquals(FunctionType.Anonymous, user1.state);
        Assert.assertEquals(FunctionType.Anonymous, user2.state);
    }

    @Test
    public void StopAnonymousTest()
    {
        anonymous.start(user1);
        anonymous.stop(user1);
        Assert.assertEquals(FunctionType.None, user1.state);
    }

    @Test
    public void ExitAnonymousTest()
    {
        anonymous.start(user1);
        Message message = new Message("/exit", user1);
        tester.handleMessage(message);
        Assert.assertEquals(FunctionType.None, user1.state);
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

