package gamesTest;

import core.Message;
import core.User;
import games.quiz.Quiz;
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
        user1 = new User<>("user1", "console");
        user2 = new User<>("user2", "console");
        tester = new TestMessageHandler();
        quiz = new Quiz(tester);
        tester.setTestedHandler(quiz);
    }

    @Test
    public void StartOneUserQuizTest()
    {
        quiz.start(user1);
        Assert.assertEquals(2, tester.queue.size());
        Assert.assertEquals("quiz", user1.state);
    }

    @Test
    public void StartTwoUserQuizTest()
    {
        quiz.start(user1);
        quiz.start(user2);
        Assert.assertEquals(4, tester.queue.size());
        Assert.assertEquals("quiz", user1.state);
        Assert.assertEquals("quiz", user2.state);
    }

    @Test
    public void StopQuizTest()
    {
        quiz.start(user1);
        quiz.stop(user1);
        Assert.assertEquals("", user1.state);
    }

    @Test
    public void ExitQuizTest()
    {
        quiz.start(user1);
        Message message = new Message("exit", user1);
        tester.handleMessage(message);
        Assert.assertEquals("", user1.state);
    }

    @Test
    public void NextQuizTest()
    {
        quiz.start(user1);
        Message message = new Message("next", user1);
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