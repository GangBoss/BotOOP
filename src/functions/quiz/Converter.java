package functions.quiz;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public final class Converter
{
    private static String firstPackage = System.getProperty("user.dir") + "\\res\\QuizQuestions.txt";

    public static List<Question> getQuestions(String path) throws Exception
    {
        {
            var quests = new ArrayList<Question>();
            var count = 0;
            var a = Paths.get(path);
            for (String line : Files.readAllLines(a, Charset.forName("windows-1251")))
            {
                count++;
                var questionFields = line.split("\\|");
                quests.add(new Question(count, questionFields[0], questionFields[1]));
            }
            return quests;
        }
    }

    public static List<Question> getQuestions() throws Exception
    {
        return getQuestions(firstPackage);
    }
}
