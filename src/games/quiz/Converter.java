package games.quiz;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public final class Converter
{
    private static String firstPackage = System.getProperty("user.dir") + "\\src\\games\\quiz\\q.txt";

    public static ArrayList<Question> getQuestions(String path) throws Exception
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

    public static ArrayList<Question> getQuestions() throws Exception
    {
        return getQuestions(firstPackage);
    }
}
