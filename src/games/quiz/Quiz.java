package games.quiz;

import core.Message;
import core.MessageHandler;
import core.User;
import games.BaseGame;
import games.quiz.commands.QuizCommandSet;

import java.util.HashMap;
import java.util.Random;

public class Quiz extends BaseGame
{
    private HashMap<User, QuizData> data = new HashMap<User, QuizData>();
    private HashMap<Integer, Question> questions = new HashMap<Integer, Question>();
    private QuizCommandSet commands = new QuizCommandSet();
    private MessageHandler bot;

    public Quiz(MessageHandler bot) throws Exception
    {
        var questions = Converter.getQuestions();
        for (var question : questions)
            this.questions.put(question.id, question);
        this.bot = bot;
    }

    @Override
    public void start(User user)
    {
        if (!data.containsKey(user)) data.put(user, new QuizData());
        sendMessage(new Message("Hello, you start quiz game. If you want exit from quiz type /exit", user));
        user.state = "quiz";
        var uData = data.get(user);
        uData.currentQuestionId = getRandomQuestionId();
        sendMessage(new Message(questions.get(uData.currentQuestionId).question, user));
    }

    @Override
    public void stop(User user)
    {
        user.state = "";
    }

    @Override
    public void sendMessage(Message message)
    {
        bot.sendMessage(message);
    }

    @Override
    public void handleMessage(Message message)
    {
        if (commands.hasCommand(message.text))
            commands.find(message.text).execute(this, message.user);
        else if (questions.get(data.get(message.user).currentQuestionId).isRight(message.text))
        {
            var quizData = data.get(message.user);
            quizData.rightAnswers++;
            quizData.currentQuestionId = getRandomQuestionId();
            sendMessage(new Message("Правильно", message.user));
            sendMessage(new Message(questions.get(quizData.currentQuestionId).question, message.user));
        } else
        {
            sendMessage(new Message("Wrong answer", message.user));
        }
    }

    public void next(User user)
    {

        var quizData = data.get(user);
        sendMessage(new Message("Right: " + questions.get(quizData.currentQuestionId).getAnswer(), user));
        quizData.currentQuestionId = getRandomQuestionId();
        sendMessage(new Message("Go next", user));
        sendMessage(new Message(questions.get(quizData.currentQuestionId).question, user));
    }

    private int getRandomQuestionId()
    {
        Random generator = new Random();
        var array = questions.keySet().toArray();
        return (int) array[generator.nextInt(array.length)];
    }
}
