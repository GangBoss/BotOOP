package functions.quiz;

import core.Message;
import core.MessageHandler;
import core.User;
import data.user.UserDatabase;
import functions.BaseFunction;
import functions.FunctionType;
import functions.quiz.commands.QuizCommandSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Quiz extends BaseFunction
{
    private HashMap<Integer, Question> questions = new HashMap<>();
    private QuizCommandSet commands = new QuizCommandSet();
    private QuizButtons buttons;
    private QuizDataBase dataBase;

    public Quiz(MessageHandler bot) throws Exception
    {
        type = FunctionType.Quiz;
        dataBase = new QuizDataBase();
        var questions = Converter.getQuestions();
        for (var question : questions)
            this.questions.put(question.id, question);
        this.bot = bot;
        buttons = new QuizButtons(dataBase);
    }
//gg
    @Override
    public void start(User user)
    {
        user.state = FunctionType.Quiz;
        if (!dataBase.quizData.containsKey(user))
            dataBase.quizData.put(user, new QuizData());
        dataBase.ChangeState(user, QuizState.Quiz);
        sendMessage(new Message("Hello, you start quiz game.  If you want exit from quiz type /exit", user));
        askQuestion(user);
    }

    @Override
    public void stop(User user)
    {
        user.state = FunctionType.None;
        sendMessage(new Message("You are living quiz", user));
        dataBase.quizData.remove(user);
    }

    @Override
    public List<String> getButtons(User user)
    {
        return buttons.getButtons(user);
    }

    @Override
    public void handleMessage(Message message)
    {
        var user = UserDatabase.getUser(message.id);
        if (commands.hasItem(message.text))
        {
            commands.find(message.text).execute(this, message);
        } else if (questions.get(dataBase.quizData.get(user).currentQuestionId).isCorrect(message))
        {
            var quizData = dataBase.quizData.get(user);
            quizData.rightAnswers++;
            sendMessage(new Message("Правильно", message.id));
            askQuestion(user);
        } else
        {
            sendMessage(new Message("Wrong answer", message.id));
        }
    }

    public void next(User user)
    {
        var quizData = dataBase.quizData.get(user);
        var currentAnswer = questions.get(quizData.currentQuestionId).getAnswer();
        sendMessage(new Message("Right: " + currentAnswer, user));
        sendMessage(new Message("Go next", user));
        askQuestion(user);
    }

    private int getRandomQuestionId()
    {
        Random generator = new Random();
        var array = questions.keySet().toArray();
        return (int) array[generator.nextInt(array.length)];
    }

    public void askQuestion(User user)
    {
        var quizData = dataBase.quizData.get(user);
        quizData.currentQuestionId = getRandomQuestionId();
        sendMessage(new Message(questions.get(quizData.currentQuestionId).question, user));
    }
}
