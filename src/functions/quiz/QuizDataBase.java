package functions.quiz;

import com.google.inject.internal.cglib.core.$Customizer;
import core.User;

import java.util.HashMap;

class QuizDataBase
{
    static HashMap<User, QuizData> quizData = new HashMap<>();
    static void ChangeState(User user, QuizState quizState){
        var currentData=quizData.get(user);
        currentData.state=quizState;
    }
}

