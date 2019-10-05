package gamesTest;

import core.Message;
import core.PlatformType;
import core.User;
import data.user.UserDatabase;
import functions.FunctionType;
import functions.quiz.Quiz;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import testHelpers.TestMessageHandler;

public class QuizTest
{
    private Quiz quiz;
    private TestMessageHandler tester;
    private User<String> user1;
    private User<String> user2;

    @Before
    public void setUp() throws Exception
    {
        UserDatabase.clear();
        user1 = new User<>("user1", PlatformType.Console);
        user2 = new User<>("user2", PlatformType.Console);
        UserDatabase.addUser(user1);
        UserDatabase.addUser(user2);
        tester = new TestMessageHandler();
        quiz = new Quiz(tester);
        tester.setTestedHandler(quiz);
    }

    @Test
    public void StartOneUserQuizTest()
    {
        quiz.start(user1);
        Assert.assertEquals(2, tester.queue.size());
        Assert.assertEquals(FunctionType.Quiz, user1.state);
    }

    @Test
    public void StartTwoUserQuizTest()
    {
        quiz.start(user1);
        quiz.start(user2);
        Assert.assertEquals(4, tester.queue.size());
        Assert.assertEquals(FunctionType.Quiz, user1.state);
        Assert.assertEquals(FunctionType.Quiz, user2.state);
    }

    @Test
    public void StopQuizTest()
    {
        quiz.start(user1);
        quiz.stop(user1);
        Assert.assertEquals(FunctionType.None, user1.state);
    }

    @Test
    public void ExitQuizTest()
    {
        quiz.start(user1);
        Message message = new Message("/exit", user1);
        tester.handleMessage(message);
        Assert.assertEquals(FunctionType.None, user1.state);
    }

    @Test
    public void NextQuizTest()
    {
        quiz.start(user1);
        Message message = new Message("/next", user1);
        tester.handleMessage(message);
        Assert.assertEquals(5, tester.queue.size());
    }

    @Test
    public void NotCommandQuizTest()
    {
        quiz.start(user1);
        Message message = new Message("test", user1);
        tester.handleMessage(message);
        Assert.assertEquals(3, tester.queue.size());
    }

    //TODO: RightAnswerCheck
}