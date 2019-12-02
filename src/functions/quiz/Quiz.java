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
import java.util.Random;

public class Quiz extends BaseFunction
{
    private HashMap<Integer, Question> questions = new HashMap<>();
    private QuizCommandSet commands = new QuizCommandSet();
    private QuizButtons buttons;
    private MessageHandler bot;

    public Quiz(MessageHandler bot) throws Exception
    {
        type = FunctionType.Quiz;
        var questions = Converter.getQuestions();
        for (var question : questions)
            this.questions.put(question.id, question);
        this.bot = bot;
        buttons = new QuizButtons();
    }

    @Override
    public void start(User user)
    {
        user.state = FunctionType.Quiz;
        if (!QuizDataBase.quizData.containsKey(user))
            QuizDataBase.quizData.put(user, new QuizData());
        QuizDataBase.ChangeState(user, QuizState.MainMenu);
        sendMessage(new Message("Hello, you start quiz game.  If you want exit from quiz type /exit", user));
        askQuestion(user);
        QuizDataBase.ChangeState(user, QuizState.Quiz);
    }

    @Override
    public void stop(User user)
    {
        user.state = FunctionType.None;
        QuizDataBase.quizData.remove(user);
        sendMessage(new Message("You are living quiz", user));
    }

    @Override
    public ArrayList<String> getButtons(User user)
    {
        return buttons.getButtons(user);
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
        {
            commands.find(message.text).execute(this, message);
        } else if (questions.get(QuizDataBase.quizData.get(user).currentQuestionId).isCorrect(message))
        {
            var quizData = QuizDataBase.quizData.get(user);
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
        var quizData = QuizDataBase.quizData.get(user);
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
        var quizData = QuizDataBase.quizData.get(user);
      //  if (quizData.state == QuizState.Quiz.MainMenu)
        //    QuizDataBase.ChangeState(user, QuizState.MainMenu);
        quizData.currentQuestionId = getRandomQuestionId();
        sendMessage(new Message(questions.get(quizData.currentQuestionId).question, user));
    }
}
