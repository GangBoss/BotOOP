package functions.quiz;

import core.Message;
import core.MessageHandler;
import core.User;
import data.user.UserDatabase;
import functions.BaseFunction;
import functions.FunctionType;
import functions.quiz.commands.QuizCommandSet;

import java.util.HashMap;
import java.util.Random;

public class Quiz extends BaseFunction
{
    private HashMap<User, QuizData> data = new HashMap<>();
    private HashMap<Integer, Question> questions = new HashMap<>();
    private QuizCommandSet commands = new QuizCommandSet();
    private MessageHandler bot;

    public Quiz(MessageHandler bot) throws Exception
    {
        type = FunctionType.Quiz;
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
        user.state = FunctionType.Quiz;
        var uData = data.get(user);
        uData.currentQuestionId = getRandomQuestionId();
        sendMessage(new Message(questions.get(uData.currentQuestionId).question, user));
    }

    @Override
    public void stop(User user)
    {
        user.state = FunctionType.None;
    }

    @Override
    public void sendMessage(Message message)
    {
        bot.sendMessage(message);
    }

    @Override
    public void handleMessage(Message message)
    {
        var user = UserDatabase.getUser(message.id);
        if (commands.hasItem(message.text))
            commands.find(message.text).execute(this, user);
        else if (questions.get(data.get(user).currentQuestionId).isCorrect(message.text))
        {
            var quizData = data.get(user);
            quizData.rightAnswers++;
            quizData.currentQuestionId = getRandomQuestionId();
            sendMessage(new Message("Правильно", message.id));
            sendMessage(new Message(questions.get(quizData.currentQuestionId).question, message.id));
        } else
        {
            sendMessage(new Message("Wrong answer", message.id));
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
