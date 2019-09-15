package games.quiz;

import core.Bot;
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
    private Bot bot;

    public Quiz(Bot bot) throws Exception
    {
        var questions = Converter.getQuestions();
        for (var question : questions)
            this.questions.put(question.id, question);
        this.bot = bot;
    }

    public void start(User user)
    {
        if (!data.containsKey(user)) data.put(user, new QuizData());
        sendMessage("Hello, you start quiz game. If you want exit from quiz type exitQuiz", user);
        user.state = "quiz";
        var uData = data.get(user);
        uData.currentQuestionId = getRandomQuestionId();
        sendMessage(questions.get(uData.currentQuestionId).question, user);
    }

    private int getRandomQuestionId()
    {
        Random generator = new Random();
        var array = questions.keySet().toArray();
        return (int) array[generator.nextInt(array.length)];
    }

    public void stop(User user)
    {
        user.state = "";
    }

    @Override
    public void sendMessage(String message, User user)
    {
        bot.sendMessage(message, user);
    }

    @Override
    public void handleMessage(String message, User user)
    {
        if (commands.hasCommand(message))
            commands.find(message).execute(this, user);
        else if (questions.get(data.get(user).currentQuestionId).isRight(message))
        {
            var quizData = data.get(user);
            quizData.rightAnswers++;
            quizData.currentQuestionId = getRandomQuestionId();
            sendMessage("Правильно", user);
            sendMessage(questions.get(quizData.currentQuestionId).question, user);
        } else
        {
            sendMessage("Wrong answer", user);
        }
    }
}
