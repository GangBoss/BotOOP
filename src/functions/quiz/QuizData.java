package functions.quiz;

import core.Statable;

import java.util.ArrayList;

public class QuizData implements Statable<QuizState>
{
    QuizState state;
    int currentQuestionId;
    int rightAnswers;
    int wrongAnswers;

    @Override
    public QuizState getState()
    {
        return state;
    }
}
